package com.example.android.commitcontent.ime.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

/**
 * Created by taqtile on 7/21/17.
 */

public abstract class PermissionChecker {

	private String manifestPermission = "";
	private int requestCode;

	PermissionChecker(String manifestPermission, int requestCode) {
		this.manifestPermission = manifestPermission;
		this.requestCode = requestCode;
	}

	public int getRequestCode() {
		return requestCode;
	}

	public boolean isPermissionGranted(Activity activity) {
		return activity != null &&
				isGranted(ContextCompat.checkSelfPermission(activity, manifestPermission));
	}

	private boolean isGranted(int permissionResult) {
		return permissionResult == PackageManager.PERMISSION_GRANTED;
	}

	public void askForPermission(Activity activity) {
		if (activity != null) {
			ActivityCompat.requestPermissions(activity, new String[]{manifestPermission}, requestCode);
		}
	}

	public boolean didPermissionResultSuccess(int requestCode, int[] grantResults) {
		return requestCode == this.requestCode &&
				grantResults.length > 0 &&
				grantResults[0] == PackageManager.PERMISSION_GRANTED;
	}

}