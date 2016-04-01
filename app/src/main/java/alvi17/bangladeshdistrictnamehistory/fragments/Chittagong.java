package alvi17.bangladeshdistrictnamehistory.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import alvi17.bangladeshdistrictnamehistory.ListAdapter;
import alvi17.bangladeshdistrictnamehistory.R;

/**
 * Created by Alvi17 on 7/26/2015.
 */
public class Chittagong extends Fragment{
    String[] district;
    String[] data;
    public Chittagong()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_layout,container,false);

        data=getActivity().getResources().getStringArray(R.array.ctg_data);
        district=getActivity().getResources().getStringArray(R.array.ctg_division);
        ListView list=(ListView)rootView.findViewById(R.id.listView);
        ListAdapter adapter=new ListAdapter(getActivity(),district,data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(listItemListener);
        return rootView;
    }
    AdapterView.OnItemClickListener listItemListener=new AdapterView.OnItemClickListener() {


        public void onItemClick(android.widget.AdapterView<?> arg0, android.view.View arg1, int arg2, long arg3) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            Long i=arg3;
            String shareBody =district[i.intValue()]+"\n ------"+data[i.intValue()];
            Log.e("DATA", shareBody);
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share History");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        };
    };
}
