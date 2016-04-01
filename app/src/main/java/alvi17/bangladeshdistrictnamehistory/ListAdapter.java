package alvi17.bangladeshdistrictnamehistory;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Alvi17 on 7/5/2015.
 */
public class ListAdapter extends ArrayAdapter<String>{
    String[] header;
    String[] data;
    Activity Context;
    public ListAdapter(Activity context,String[] header,String[] data)
    {
        super(context,R.layout.custom_list_item,header);
        this.Context=context;
        this.header=header;
        this.data=data;
    }

    public class Holder
    {
        TextView head;
        TextView details;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = Context.getLayoutInflater();
        Holder holder=new Holder();
        View rowView= inflater.inflate(R.layout.custom_list_item, null,true);
        holder.head=(TextView)rowView.findViewById(R.id.headertextView);
        holder.details=(TextView)rowView.findViewById(R.id.detailtextView);

        holder.head.setText(header[position]);
        holder.details.setText(data[position]);

        int sdkVersion = Build.VERSION.SDK_INT;
        if(sdkVersion<17) {
            holder.details.setTextColor(Color.WHITE);
        }

        return rowView;
    }
}
