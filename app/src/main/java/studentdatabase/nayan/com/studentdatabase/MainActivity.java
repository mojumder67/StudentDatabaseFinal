package studentdatabase.nayan.com.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;

    ImageView myImageView;
    EditText editText_Name, editText_Id, editText_MobileNumber, editText_Email;
    Button save_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        editText_Name = (EditText) findViewById(R.id.etName);
        editText_Id = (EditText) findViewById(R.id.etId);
        editText_MobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        editText_Email = (EditText) findViewById(R.id.etEmail);
        save_data = (Button) findViewById(R.id.btSave);
        addData();

    }
    public void addData(){
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertData(editText_Name.getText().toString(),
                                editText_Id.getText().toString(),
                                editText_MobileNumber.getText().toString(),
                                editText_Email.getText().toString());
                if (isInserted = true)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
