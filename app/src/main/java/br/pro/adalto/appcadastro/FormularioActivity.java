package br.pro.adalto.appcadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etTelefone, etEmail;
    private CheckBox cbCaminhada, cbCorrida;
    private RadioButton rbFeminino, rbMasculino;
    private Button btnSalvar;

    private Spinner spinnerEstado, spinnerCidade;

    private ArrayAdapter adapter;
    private String[] listaCidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome =      (EditText)    findViewById(R.id.etNome);
        etTelefone =  (EditText)    findViewById(R.id.etTelefone);
        etEmail =     (EditText)    findViewById(R.id.etEmail);

        cbCaminhada = (CheckBox)    findViewById(R.id.cbCaminhada);
        cbCorrida =   (CheckBox)    findViewById(R.id.cbCorrida);

        rbFeminino =  (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);

        btnSalvar =   (Button)      findViewById(R.id.btnSalvar);



        spinnerCidade = (Spinner) findViewById(R.id.spCidade);
        spinnerEstado = (Spinner) findViewById(R.id.spEstado);

        spinnerCidade.setEnabled(false);

        listaCidades = new String[]{
                getResources().getString(R.string.selecioneEstado) };

        adapter = new ArrayAdapter( this ,
                android.R.layout.simple_list_item_1, listaCidades);
        spinnerCidade.setAdapter(adapter);


        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                carregarCidades();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void carregarCidades(){
        String selecione = getResources().getString(R.string.selecione);
        String selecioneEstado = getResources().getString(R.string.selecioneEstado);

        String[] AC = { selecione , "Rio Branco"};
        String[] RS = { selecione , "Alvorada", "Canoas", "Capão da Canoa", "Porto Alegre", "Viamão" };
        String[] SC = { selecione , "Florinópolis", "Itapema", "Passo de Torres", "Praia Grande", "Tubarão"};
        String[] PR = { selecione , "Curitiba", "Foz do Iguaçú", "Maringá"};


        int posicao = spinnerEstado.getSelectedItemPosition();

        switch (posicao) {
            case 0:
                spinnerCidade.setEnabled(false);
                listaCidades = new String[]{ getResources().getString(R.string.selecioneEstado) };
                break;
            case 1:
                spinnerCidade.setEnabled(true);
                listaCidades = AC;
                break;
            case 17:
                spinnerCidade.setEnabled(true);
                listaCidades = PR;
                break;
            case 21:
                spinnerCidade.setEnabled(true);
                listaCidades = RS;
                break;
            case 24:
                spinnerCidade.setEnabled(true);
                listaCidades = SC;
                break;
            default:
                spinnerCidade.setEnabled(true);
                listaCidades = new String[]{ getResources().getString(R.string.selecione) };
                break;
        }
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listaCidades);
        spinnerCidade.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_formulario , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if ( item.getItemId() == R.id.menu_sair ){
            finish();
        }

        if ( item.getItemId() == R.id.menu_limpar ){
            limpar();
        }

        return super.onOptionsItemSelected(item);
    }

    private void limpar(){
        etNome.setText("");
        etTelefone.setText("");
        etEmail.setText("");

        cbCaminhada.setChecked(false);
        cbCorrida.setChecked(false);
        rbMasculino.setChecked(false);
        rbFeminino.setChecked(false);

        spinnerEstado.setSelection( 0 );




    }

}
