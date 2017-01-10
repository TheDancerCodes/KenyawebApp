package com.kenyaweb.kenyawebapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements View.OnClickListener {




    public ContactFragment() {
        // Required empty public constructor
    }

    Button btn_call_nrb, btn_call_msa, btn_mail_nrb, btn_mail_msa, btn_website,btn_fb,btn_tw,btn_ln;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        btn_call_nrb=(Button) view.findViewById(R.id.btn_call_nrb);
        btn_call_nrb.setOnClickListener(this);

        btn_call_msa = (Button) view.findViewById(R.id.btn_call_msa);
        btn_call_msa.setOnClickListener(this);

        btn_mail_nrb = (Button) view.findViewById(R.id.btn_mail_nrb);
        btn_mail_nrb.setOnClickListener(this);

        btn_mail_msa = (Button) view.findViewById(R.id.btn_mail_msa);
        btn_mail_msa.setOnClickListener(this);

        btn_website = (Button) view.findViewById(R.id.btn_website);
        btn_website.setOnClickListener(this);

        btn_fb = (Button) view.findViewById(R.id.btn_fb);
        btn_fb.setOnClickListener(this);

        btn_tw = (Button) view.findViewById(R.id.btn_tw);
        btn_tw.setOnClickListener(this);

        btn_ln = (Button) view.findViewById(R.id.btn_ln);
        btn_ln.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_call_nrb:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0722205594"));
                startActivity(intent);
                break;

            case R.id.btn_call_msa:
                Intent intent_msa = new Intent(Intent.ACTION_DIAL);
                intent_msa.setData(Uri.parse("tel:0412229722"));
                startActivity(intent_msa);
                break;

            case R.id.btn_mail_nrb:
                String aEmailList[] = { "info@kenyaweb.com"};
                String CCList[] = { "marketing@kenyaweb.com"};

                Intent intent_mail_nrb = new Intent(Intent.ACTION_SENDTO);
                intent_mail_nrb.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent_mail_nrb.putExtra(Intent.EXTRA_EMAIL, aEmailList);
                intent_mail_nrb.putExtra(Intent.EXTRA_CC, CCList);
                intent_mail_nrb.putExtra(Intent.EXTRA_SUBJECT, "Service Inquiry");
                startActivity(intent_mail_nrb);
                break;

            case R.id.btn_mail_msa:
                String emailList[] = { "salesmsa@kenyaweb.com"};
                String ccList[] = { "marketing@kenyaweb.com"};

                Intent intent_mail_msa = new Intent(Intent.ACTION_SENDTO);
                intent_mail_msa.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent_mail_msa.putExtra(Intent.EXTRA_EMAIL, emailList);
                intent_mail_msa.putExtra(Intent.EXTRA_CC, ccList);
                intent_mail_msa.putExtra(Intent.EXTRA_SUBJECT, "Service Inquiry");
                startActivity(intent_mail_msa);
                break;

            case R.id.btn_website:;
                Intent intent_web = new Intent(getActivity(), WebSite.class);
                startActivity(intent_web);
                break;

            case R.id.btn_fb:
                Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/kenyaweblimited/?fref=nf"));
                startActivity(fbIntent);
                break;

            case R.id.btn_tw:
                Intent twIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/KenyaweBdotCom"));
                startActivity(twIntent);
                break;

            case R.id.btn_ln:
                Intent lnIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kenyaweb-limited-453b6a120"));
                startActivity(lnIntent);
                break;

        }
    }
}
