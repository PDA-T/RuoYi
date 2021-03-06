package com.bluetoothle.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bluetoothle.utils.DecodeUtils;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class BluetoothLeService extends Service {
	private LocalBinder mBinder = new LocalBinder();
	private BluetoothManager mBluetoothManager;
	private BluetoothAdapter mBluetoothAdapter;
	private BluetoothGatt mBluetoothGatt;
	private String mBluetoothDeviceAddress;
	private String TAG = "LZ-4000T";
	private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	private int mConnectionState = STATE_DISCONNECTED;
	private Map<Object, Object> map = new HashMap<Object, Object>();

	private static final int STATE_DISCONNECTED = 0;
	private static final int STATE_CONNECTING = 1;
	private static final int STATE_CONNECTED = 2;

	public final static String ACTION_GATT_CONNECTED = "com.example.bluetooth.le.ACTION_GATT_CONNECTED";
	public final static String ACTION_GATT_DISCONNECTED = "com.example.bluetooth.le.ACTION_GATT_DISCONNECTED";
	public final static String ACTION_GATT_SERVICES_DISCOVERED = "com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED";
	public final static String ACTION_DATA_AVAILABLE = "com.example.bluetooth.le.ACTION_DATA_AVAILABLE";
	public final static String ACTION_DATA_RSSI = "com.example.bluetooth.le.ACTION_DATA_RSSI";
	public final static String EXTRA_DATA = "com.example.bluetooth.le.EXTRA_DATA";
	// public final static String ACTION_RESPONSE_

	private static final UUID serviceUUID = UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb");
	private static final UUID characteristicUUID = UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb");

	private BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {

		// ??????????????????
		@Override
		public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
			String intentAction;
			if (newState == BluetoothProfile.STATE_CONNECTED) {
				intentAction = ACTION_GATT_CONNECTED;
				mConnectionState = STATE_CONNECTED;
				broadcastUpdate(intentAction);
				// ??????????????????????
				Log.e("AAAAAAAA", "????????????:" + mBluetoothGatt.discoverServices());
			} else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
				intentAction = ACTION_GATT_DISCONNECTED;
				mConnectionState = STATE_DISCONNECTED;
				broadcastUpdate(intentAction);
			}
		}

		// ??????????????
		public void onServicesDiscovered(BluetoothGatt gatt, int status) {
			if (status == BluetoothGatt.GATT_SUCCESS) {
				broadcastUpdate(ACTION_GATT_SERVICES_DISCOVERED);
			} else {
				Log.e(TAG, "??????????????????????:" + status);
			}

		};

		// ????????????
		public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
			if (status == BluetoothGatt.GATT_SUCCESS) {
				Log.e(TAG, "????????" + DecodeUtils.byte2HexStr(characteristic.getValue()));
			}
		};

		// ????????????
		@Override
		public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
			if (status == BluetoothGatt.GATT_SUCCESS) {
				Log.e(TAG, "????????" + DecodeUtils.byte2HexStr(characteristic.getValue()));
			}
		}

		// ??????????????????????????????????????????????
		public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
			try {
				// Thread.sleep(50);
				// Log.e("byteData",DecodeUtils.byte2HexStr(characteristic.getValue())+"");
				byteArrayOutputStream.write(characteristic.getValue());
				byte[] byteData = byteArrayOutputStream.toByteArray();
				Log.e("byteData", DecodeUtils.byte2HexStr(byteData) + "");
				byte cmd = byteData[1];
				switch (cmd) {

				// ????????????????
				case 0x11:
					byte[] bb = new byte[] { byteData[5], byteData[4] };
					// ????????????????????
					int mountRecord = Integer.parseInt(DecodeUtils.bytesToAllHex(bb, 10));
					if (byteData.length == 26 * mountRecord) {
						broadcastUpdate(EXTRA_DATA, byteData);
						byteArrayOutputStream.reset();
						byteArrayOutputStream.close();
					}
					break;

				// ????????????
				case 0x15:
					byte[] cc = new byte[] { byteData[5], byteData[4] };
					int mountSampleName = Integer.parseInt(DecodeUtils.bytesToAllHex(cc, 10));
					if (byteData.length == 18 * mountSampleName) {
						broadcastUpdate(EXTRA_DATA, byteData);
						byteArrayOutputStream.close();
					}
					break;

				// ??????????????
				case 0x37:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// ????????????????
				case 0x3B:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// ????????????????
				case 0x31:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// wifi????????
				case 0x23:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// ????????????????
				case 0x1B:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// ????????????????
				case 0x21:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// ??????????????
				case 0x25:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				// UDP??????????????
				case 0x27:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;

				//????????????????
				case 0x17:
					broadcastUpdate(EXTRA_DATA, byteData);
					byteArrayOutputStream.close();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

	};

	// ????????1
	private void broadcastUpdate(final String action) {
		final Intent intent = new Intent(action);
		sendBroadcast(intent);
	}

	// ????????2
	private void broadcastUpdate(final String action, final String rssi) {
		final Intent intent = new Intent();
		intent.setAction(action);
		intent.putExtra(ACTION_DATA_RSSI, rssi);
		sendBroadcast(intent);
	}

	// ????????3
	private void broadcastUpdate(final String action, byte[] bb) {
		final Intent intent = new Intent();
		intent.setAction(action);
		Bundle bundle = new Bundle();
		bundle.putByteArray(EXTRA_DATA, bb);
		intent.putExtra(EXTRA_DATA, bundle);
		sendBroadcast(intent);
	}

	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	public class LocalBinder extends Binder {
		public BluetoothLeService getService() {
			return BluetoothLeService.this;
		}
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	// ????????????????????
	public boolean initialize() {
		if (mBluetoothManager == null) {
			mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
			if (mBluetoothManager == null) {
				Log.e(TAG, "bluetoothmanager??????????");
				return false;
			}
		}
		mBluetoothAdapter = mBluetoothManager.getAdapter();
		if (mBluetoothAdapter == null) {
			Log.e(TAG, "???????? ??mBluetoothAdapter");
			return false;
		}
		return true;
	}

	// connect??????????????
	public boolean connect(String address) {
		if (mBluetoothAdapter == null || address == null) {
			Log.e(TAG, "????????????????????????");
			return false;
		}

		// ????????????????????
		if (mBluetoothDeviceAddress != null && address.equals(mBluetoothDeviceAddress) && mBluetoothGatt != null) {
			if (mBluetoothGatt.connect()) {
				mConnectionState = STATE_CONNECTING;
				return true;
			} else {
				return false;
			}
		}

		// ??????????
		BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
		mBluetoothGatt = device.connectGatt(this, false, mGattCallback);
		mBluetoothDeviceAddress = address;
		mConnectionState = STATE_CONNECTING;
		return true;
	}

	// ????????
	public void disconnect() {
		if (mBluetoothAdapter == null || mBluetoothGatt == null) {
			return;
		}
		mBluetoothGatt.disconnect();
	}

	// ??????????BLE?????????????????????????????????????????? ??????????
	public void close() {
		if (mBluetoothGatt == null) {
			return;
		}
		mBluetoothGatt.close();
		mBluetoothGatt = null;
	}

	// ????BLE????????????????
	public List<BluetoothGattService> getSupportedGattServices() {
		if (mBluetoothGatt == null) {
			return null;
		}
		return mBluetoothGatt.getServices();
	}

	// ??????
	public void readCharacteristic(BluetoothGattCharacteristic characteristic) {
		if (mBluetoothAdapter == null || mBluetoothGatt == null) {
			Log.e("AAAAAAAAA", "????????????");
			return;
		}
		mBluetoothGatt.readCharacteristic(characteristic);
	}

	// ??????
	public boolean write(byte[] bb) {
		// ??????????????????????byteArrayOutputStream
		byteArrayOutputStream = new ByteArrayOutputStream();
		if (mBluetoothGatt == null) {
			Log.e("AAAAAAAA", "mBluetoothGatt????");
			return false;
		}
		BluetoothGattService mService = mBluetoothGatt.getService(serviceUUID);
		if (mService == null) {
			Log.e("AAAAA", "??????????LZ-4000(T)????????????????????");
			return false;
		}
		BluetoothGattCharacteristic mCharacteristic = mService.getCharacteristic(characteristicUUID);
		if (mCharacteristic == null) {
			Log.e("AAAAA", "??????????LZ-4000(T)????????????????????");
			return false;
		}
		setCharacteristicNotification(mCharacteristic, true);
		mCharacteristic.setValue(bb);
		mCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
		return mBluetoothGatt.writeCharacteristic(mCharacteristic);
	}

	// ????????
	public void setCharacteristicNotification(BluetoothGattCharacteristic characteristic, boolean enabled) {
		if (mBluetoothAdapter == null || mBluetoothGatt == null) {
			Log.e("AAAAAAA", "????????????");
			return;
		}
		mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);
	}
}
