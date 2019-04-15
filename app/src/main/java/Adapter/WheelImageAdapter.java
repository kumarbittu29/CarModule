package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.oneany.www.carmodule.R;

import java.util.List;

import Data.ImageData;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context mContext;
    private List<ImageData> menuItems;
    private LayoutInflater inflater;
    private int gravity;




    public WheelImageAdapter(Context mContext,List<ImageData> menuItems){
        this.mContext = mContext;
        this.menuItems = menuItems;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public View getView(final View parent, int position) {
        final ImageData data = getItem(position);
        View root = inflater.inflate(R.layout.wheel_image_layout,null,false);
        final ToggleButton imageView = root.findViewById(R.id.wheel_menu_item_ig);
        imageView.setBackgroundResource(data.imageResources);
        imageView.setText(data.imageDescription);
        imageView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    imageView.setBackgroundResource(R.mipmap.ncc);
                    imageView.setTextOn(data.imageDescription);
                } else{
                    imageView.setBackgroundResource(data.imageResources);
                    imageView.setTextOff(data.imageDescription);

                }
            }
        });
        return root;


    }

    @Override
    public ImageData getItem(int position) {
        return menuItems.get(position);
    }
}
