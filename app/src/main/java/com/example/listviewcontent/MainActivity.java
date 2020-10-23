package com.example.listviewcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int vitri=-1;
    ListView listsinhvien;
    EditText editTen;
    EditText editSĐT;
    Button btn_them,btn_sua,btn_xoa;
    ArrayList<sinhvien> arrSinhvien;
    CustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrSinhvien= new ArrayList<sinhvien>();
        arrSinhvien.add(new sinhvien("Dương Quốc Vương","0949443045",R.drawable.utelogo));
        arrSinhvien.add(new sinhvien("Dương Hoàng Thượng","0949443045",R.drawable.utelogo));
        arrSinhvien.add(new sinhvien("Trần Văn Vũ","0949443045",R.drawable.utelogo));
        arrSinhvien.add(new sinhvien("Nguyễn Hoài An","0949443045",R.drawable.utelogo));
        myadapter= new CustomAdapter(this,R.layout.item_layout,arrSinhvien);
        listsinhvien.setAdapter(myadapter);
        listsinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri=position;
                editTen.setText(arrSinhvien.get(position).getTenSinhvien());
                editSĐT.setText(arrSinhvien.get(position).getSdtSinhvien());
            }
        });
    }
    private void anhxa(){
        listsinhvien=findViewById(R.id.List_sinhvien);
        btn_sua=findViewById(R.id.btn_update);
        btn_them=findViewById(R.id.btn_add);
        btn_xoa=findViewById(R.id.btn_delete);
        editTen=findViewById(R.id.edit_ten);
        editSĐT=findViewById(R.id.edit_sdt);
        btn_them.setOnClickListener(this);
        btn_sua.setOnClickListener(this);
        btn_xoa.setOnClickListener(this);
    }
    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            if(arrSinhvien.contains(arrSinhvien.get(position))){
                arrSinhvien.remove(arrSinhvien.get(position));
            }
            else{
                arrSinhvien.add(arrSinhvien.get(position));
            }
            mode.setTitle(arrSinhvien.size() +" items selected...");
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.context_menu, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId()){
                case R.id.action_delete:
                    myadapter.remove(arrSinhvien);
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            arrSinhvien.clear();
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                Toast.makeText(this,"click vao bt them",Toast.LENGTH_LONG).show();
                String ten=editTen.getText().toString();
                String sdt=editSĐT.getText().toString();
                sinhvien temp= new sinhvien(ten,sdt,R.drawable.utelogo);
                arrSinhvien.add(temp);
                myadapter.notifyDataSetChanged();
                break;
            case R.id.btn_update:
                Toast.makeText(this,"click vao bt update",Toast.LENGTH_LONG).show();
                sinhvien svsua = new sinhvien(editTen.getText().toString(),editSĐT.getText().toString(),R.drawable.utelogo);
                arrSinhvien.set(vitri,svsua);
                myadapter.notifyDataSetChanged();
                break;
            case R.id.btn_delete:
                Toast.makeText(this,"click vao bt update",Toast.LENGTH_LONG).show();
                arrSinhvien.remove(vitri);
                myadapter.notifyDataSetChanged();
                break;


        }

    }
}