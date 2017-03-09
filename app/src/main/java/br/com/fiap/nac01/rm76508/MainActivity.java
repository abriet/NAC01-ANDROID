package br.com.fiap.nac01.rm76508;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup  rgMateria;
    EditText    edtMetros;
    CheckBox    chkFrete;
    TextView    txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgMateria       = (RadioGroup) findViewById(R.id.rgMateriais);
        edtMetros       = (EditText) findViewById(R.id.edtMetros);
        chkFrete        = (CheckBox) findViewById(R.id.chkFrete);
        txtResultado    = (TextView) findViewById(R.id.txtResultado);


        if(edtMetros.getText().toString().isEmpty()){
            edtMetros.setText(R.string.valor_padrao);
        }
    }

    public void calcular(View view) {
        if (edtMetros.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.msg_erro, Toast.LENGTH_SHORT).show();
            txtResultado.setVisibility(View.INVISIBLE);
        }else {
            int selecionado = rgMateria.getCheckedRadioButtonId();
            double valor = 0;
            int metros = Integer.parseInt(edtMetros.getText().toString());

            if (selecionado == R.id.rbItem1) {
                valor = 24.90;
            } else if (selecionado == R.id.rbItem2) {
                valor = 11.90;
            } else if (selecionado == R.id.rbItem3) {
                valor = 39.90;
            } else if (selecionado == R.id.rbItem4) {
                valor = 16.90;
            }

            valor *= (metros * metros);

            if (chkFrete.isChecked()) {
                valor *= 1.3;
            }
            String resultado = String.format(getString(R.string.padrao_valor), valor);
            txtResultado.setText(getString(R.string.moeda_dolar) + resultado);
            txtResultado.setVisibility(View.VISIBLE);
        }

    }
}
