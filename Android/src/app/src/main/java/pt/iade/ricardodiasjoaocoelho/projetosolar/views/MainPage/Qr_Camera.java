package pt.iade.ricardodiasjoaocoelho.projetosolar.views.MainPage;

import static androidx.core.content.ContextCompat.getMainExecutor;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;

import java.util.List;
import java.util.concurrent.ExecutionException;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Qr_Camera extends Fragment {

    ListenableFuture<ProcessCameraProvider> cameraProviderFuture;

    View view;

    public Qr_Camera() {super(R.layout.qr_camera_activity);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        LifecycleOwner lifecycleOwner = this;

        PreviewView previewView = view.findViewById(R.id.qr_camera_preview);

        if (ContextCompat.checkSelfPermission(view.getContext(), android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startCamera(lifecycleOwner, previewView);
        }
        else
        {
            requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 101);
        }
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PreviewView previewView = view.findViewById(R.id.qr_camera_preview);
        LifecycleOwner lifecycleOwner = this;

        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera(lifecycleOwner, previewView);
            } else {
                Snackbar.make(previewView, "Camera permission is required.", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void startCamera(LifecycleOwner lifecycleOwner, PreviewView previewView) {
        cameraProviderFuture = ProcessCameraProvider.getInstance(view.getContext());

        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                ProcessCameraProvider cameraProvider = null;
                try {
                    cameraProvider = cameraProviderFuture.get();
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

                ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().build();

                imageAnalysis.setAnalyzer(getMainExecutor(view.getContext()), new ImageAnalysis.Analyzer() {
                    @Override
                    public void analyze(@NonNull ImageProxy image) {
                        InputImage inputImage = InputImage.fromMediaImage(image.getImage(), image.getImageInfo().getRotationDegrees());

                        BarcodeScanner scanner = BarcodeScanning.getClient();

                        Task<List<Barcode>> results = scanner.process(inputImage);

                        results.addOnSuccessListener(barcodes -> {
                                    for (Barcode barcode : barcodes) {
                                        String rawValue = barcode.getRawValue();
                                        Snackbar.make(previewView, rawValue, Snackbar.LENGTH_SHORT).show();
                                    }
                                    image.close();
                                });
                    }
                });

                Preview preview = new Preview.Builder().build();
                CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();

                preview.setSurfaceProvider(previewView.getSurfaceProvider());
                cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, preview, imageAnalysis);
            }
        }, getMainExecutor(view.getContext()));
    }
}
