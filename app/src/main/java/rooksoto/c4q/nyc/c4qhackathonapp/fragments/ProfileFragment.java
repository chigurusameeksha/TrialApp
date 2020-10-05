package rooksoto.c4q.nyc.c4qhackathonapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import rooksoto.c4q.nyc.c4qhackathonapp.R;

/**
 * Created by shannonalexander-navarro on 2/18/17.
 */

public class ProfileFragment extends Fragment {

    private Spinner languageSpinner;
    private ImageView profileIV;
    private Button button;
    private EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout, container, false);

        languageSpinner = (Spinner) view.findViewById(R.id.language_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.language_array,  android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        profileIV = (ImageView) view.findViewById(R.id.profilePic);
        Picasso.with(view.getContext()).load(R.drawable.lily_profile_pic).into(profileIV);

        button = (Button) view.findViewById(R.id.saveBtn);
        editText = (EditText) view.findViewById(R.id.userName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Changes saved", Toast.LENGTH_SHORT).show();
                String inputName = String.valueOf(editText.getText());
                if (editText != null){
                    editText.setText(inputName);
                }
            }
        });

        return view;
    }



}
