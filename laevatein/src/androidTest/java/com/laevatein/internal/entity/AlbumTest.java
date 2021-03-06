package com.laevatein.internal.entity;

import com.laevatein.R;

import android.database.MatrixCursor;
import android.provider.MediaStore;
import android.test.AndroidTestCase;

/**
 * @author KeithYokoma
 * @since 2014/04/01
 */
public class AlbumTest extends AndroidTestCase {
    private static final String[] MOCK_PROJECTION = new String[]{ MediaStore.Images.Media._ID, MediaStore.Images.Media.BUCKET_ID, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

    public void testValueOf() throws Exception {
        MatrixCursor cameraRow = new MatrixCursor(MOCK_PROJECTION);
        cameraRow.addRow(new String[]{"1", "1", "Camera"});
        assertTrue(cameraRow.moveToFirst());
        Album camera = Album.valueOf(cameraRow);
        assertNotNull(camera);
        assertFalse(camera.isAll());
        assertTrue(camera.isCamera());
        assertFalse(camera.isChecked());
        assertEquals(1L, camera.getCoverId());
        assertEquals("1", camera.getId());
        assertEquals(getContext().getString(R.string.l_album_name_camera), camera.getDisplayName(getContext()));

        MatrixCursor allRow = new MatrixCursor(MOCK_PROJECTION);
        allRow.addRow(new String[]{Album.ALBUM_ID_ALL, "-1", "All"});
        assertTrue(allRow.moveToFirst());
        Album all = Album.valueOf(allRow);
        assertNotNull(all);
        assertTrue(all.isAll());
        assertFalse(all.isCamera());
        assertFalse(all.isChecked());
        assertEquals(-1L, all.getCoverId());
        assertEquals(Album.ALBUM_ID_ALL, all.getId());
        assertEquals(getContext().getString(R.string.l_album_name_all), all.getDisplayName(getContext()));

        MatrixCursor checkedRow = new MatrixCursor(MOCK_PROJECTION);
        checkedRow.addRow(new String[]{Album.ALBUM_ID_CHECKED, "-2", "Selected"});
        assertTrue(checkedRow.moveToFirst());
        Album checked = Album.valueOf(checkedRow);
        assertNotNull(checked);
        assertFalse(checked.isAll());
        assertFalse(checked.isCamera());
        assertTrue(checked.isChecked());
        assertEquals(-2L, checked.getCoverId());
        assertEquals(Album.ALBUM_ID_CHECKED, checked.getId());
        assertEquals(getContext().getString(R.string.l_album_name_selected), checked.getDisplayName(getContext()));

        MatrixCursor downloadRow = new MatrixCursor(MOCK_PROJECTION);
        downloadRow.addRow(new String[]{ "2", "2", "Download" });
        assertTrue(downloadRow.moveToFirst());
        Album download = Album.valueOf(downloadRow);
        assertNotNull(download);
        assertFalse(download.isAll());
        assertFalse(download.isCamera());
        assertFalse(download.isChecked());
        assertEquals(2L, download.getCoverId());
        assertEquals("2", download.getId());
        assertEquals(getContext().getString(R.string.l_album_name_download), download.getDisplayName(getContext()));

        MatrixCursor screenShotRow = new MatrixCursor(MOCK_PROJECTION);
        screenShotRow.addRow(new String[]{ "3", "3", "Screenshots"});
        assertTrue(screenShotRow.moveToFirst());
        Album screenShot = Album.valueOf(screenShotRow);
        assertNotNull(screenShot);
        assertFalse(screenShot.isAll());
        assertFalse(screenShot.isCamera());
        assertFalse(screenShot.isChecked());
        assertEquals(3L, screenShot.getCoverId());
        assertEquals("3", screenShot.getId());
        assertEquals(getContext().getString(R.string.l_album_name_screen_shot), screenShot.getDisplayName(getContext()));
    }
}
