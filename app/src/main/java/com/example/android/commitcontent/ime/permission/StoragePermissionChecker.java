package com.example.android.commitcontent.ime.permission;

import android.Manifest;

/**
 * Created by taqtile on 7/21/17.
 */

public class StoragePermissionChecker extends PermissionChecker{

	public StoragePermissionChecker() {
		super(Manifest.permission.WRITE_EXTERNAL_STORAGE, 1);
	}

}
