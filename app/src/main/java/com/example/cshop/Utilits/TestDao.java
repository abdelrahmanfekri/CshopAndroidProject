package com.example.cshop.Utilits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cshop.Data.Dao;
import com.example.cshop.Objects.Parentshop;
import com.example.cshop.Objects.Product;
import com.example.cshop.Objects.Restaurant;
import com.example.cshop.Objects.SuperMarket;
import com.example.cshop.Objects.Vegetables;
import com.example.cshop.R;

import java.security.acl.Group;
import java.util.HashMap;
import java.util.Map;

public class TestDao extends AppCompatActivity {

    private TextView Title;
    private EditText name, description,price_product,name_product,description_product;
    private Button add,add_product,delete,update,update_product,delete_product;
    private View addProductLayout;
    private static final String TAG = "TestDao";
    private Product current;
    private Dao dao;
    private RadioGroup group;
    private Parentshop Shop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dao);
        intialize();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_Restaurant:
                        dao = new Dao<Restaurant>(Restaurant.class.getSimpleName(),TestDao.this);
                        break;
                    case R.id.radio_Supermarket:
                        dao = new Dao<SuperMarket>(SuperMarket.class.getSimpleName(),TestDao.this);
                        break;
                    case R.id.radio_Vegetables:
                        dao = new Dao<Vegetables>(Vegetables.class.getSimpleName(),TestDao.this);
                        break;
                }
            }
        });
    }
    private void intialize() {
        name = ((EditText)findViewById(R.id.edit_name));
        name.getText().clear();

        description =((EditText) findViewById(R.id.edit_description));
        description.getText().clear();

        add = findViewById(R.id.add);
        add.setVisibility(View.VISIBLE);

        update = findViewById(R.id.update);
        update.setVisibility(View.INVISIBLE);

        delete = findViewById(R.id.delete);
        delete.setVisibility(View.INVISIBLE);

        price_product =((EditText) findViewById(R.id.edit_price));
        price_product.getText().clear();

        name_product = ((EditText)findViewById(R.id.edit_name_product));
        name_product.getText().clear();

        description_product =((EditText) findViewById(R.id.edit_descritption_product));
        description_product.getText().clear();

        add_product = findViewById(R.id.add_product);
        add_product.setVisibility(View.VISIBLE);

        update_product = findViewById(R.id.update_product);
        update_product.setVisibility(View.INVISIBLE);

        delete_product = findViewById(R.id.delete_product);
        delete_product.setVisibility(View.INVISIBLE);

        addProductLayout = findViewById(R.id.addPoductLayout);
        addProductLayout.setVisibility(View.INVISIBLE);

        Title = findViewById(R.id.TitleText);
        Title.setText("CheckBox");

        group= findViewById(R.id.RAdioGroub);
        group.setVisibility(View.VISIBLE);
        group.check(R.id.radio_Restaurant);

        dao = new Dao<Restaurant>(Restaurant.class.getSimpleName(),TestDao.this);


    }
    public void addShop(View view){
        String Sname = name.getText().toString();
        String Sdes = description.getText().toString();
        if(Sname==null||Sdes == null|| Sname.equals("")||Sdes.equals("")){
            Toast.makeText(TestDao.this, "Please Fill All Required Data", Toast.LENGTH_SHORT).show();
            return;
        }
        add.setVisibility(View.INVISIBLE);
        update.setVisibility(View.VISIBLE);
        delete.setVisibility(View.VISIBLE);
        Shop = new Parentshop(name.getText().toString(),description.getText().toString());
        dao.add(Shop);
        addProductLayout.setVisibility(View.VISIBLE);
        switch (group.getCheckedRadioButtonId()){
            case R.id.radio_Restaurant:
                Title.setText("Restaurant");
                break;
            case R.id.radio_Supermarket:
                Title.setText("SuperMarket");
                break;
            case R.id.radio_Vegetables:
                Title.setText("Vegetables");
                break;
        }
        group.setVisibility(View.INVISIBLE);
    }
    public void updateShop(View view){
        String Sname = name.getText().toString();
        String Sdes = description.getText().toString();
        if(Sname==null||Sdes == null|| Sname.equals("")||Sdes.equals("")){
            Toast.makeText(TestDao.this, "Please Fill All Required Data", Toast.LENGTH_SHORT).show();
            return;
        }
        Shop.setName(Sname);
        Shop.setDescription(Sdes);
        Map<String,String> map = new HashMap<>();
        map.put("name",Sname);
        map.put("description",Sdes);
        dao.update(Shop.getAddress(),map);
    }
    public void deleteShop(View view){
        dao.remove(Shop.getAddress());
        intialize();
    }
    public void addProduct(View view){
        String sname = name_product.getText().toString();
        String sdes = description_product.getText().toString();
        String sprice = price_product.getText().toString();
        if(sname==null||sname.equals("")||sdes==null||sdes.equals("")||sprice==null||sprice.equals("")){
            Toast.makeText(this, "Please Fill All The Requared", Toast.LENGTH_SHORT).show();
            return ;
        }
        current = new Product(sname,sdes,sprice);
        Dao daoProduct = new Dao<Product>(Product.class.getSimpleName(),this);
        daoProduct.add(current);
        Shop.addProduct(current.getAddress());
        add_product.setVisibility(View.VISIBLE);
    }
    public void updateProduct(View view){
        String sname = name_product.getText().toString();
        String sdes = description_product.getText().toString();
        String sprice = price_product.getText().toString();
        if(sname==null||sname.equals("")||sdes==null||sdes.equals("")||sprice==null||sprice.equals("")){
            Toast.makeText(this, "Please Fill All The Requared", Toast.LENGTH_SHORT).show();
            return ;
        }
        current.setName(sname);
        current.setDescritption(sdes);
        current.setPrice(sprice);
        Toast.makeText(this, "Success Update", Toast.LENGTH_SHORT).show();
    }
    public void deleteProduct(View view){
        name_product.getText().clear();
        description_product.getText().clear();
        price_product.getText().clear();
        if(Shop.getProducts().contains(current)){
            Shop.getProducts().remove(current);
            current = null;
        }
        add_product.setVisibility(View.VISIBLE);
        update_product.setVisibility(View.INVISIBLE);
        delete_product.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Success Delete", Toast.LENGTH_SHORT).show();
    }

}