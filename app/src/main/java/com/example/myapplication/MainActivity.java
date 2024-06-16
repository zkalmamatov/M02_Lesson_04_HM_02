package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLogin, editTextPassword;
    private Button buttonLogin;
    private TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textWelcome = findViewById(R.id.textWelcome);

        // Проверка текста в EditText для изменения background кнопки
        editTextLogin.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s) {
                updateButtonBackground();
            }
        });

        editTextPassword.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s) {
                updateButtonBackground();
            }
        });

        // Обработка нажатия кнопки Войти
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    // Метод для обновления background кнопки в зависимости от текста в EditText
    private void updateButtonBackground() {
        if (!editTextLogin.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()) {
            buttonLogin.setEnabled(true);
            buttonLogin.setBackgroundResource(R.drawable.button_enabled_bg);
        } else {
            buttonLogin.setEnabled(false);
            buttonLogin.setBackgroundResource(R.drawable.button_disabled_bg);
        }
    }

    // Метод для проверки логина и пароля
    private void login() {
        String login = editTextLogin.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (login.equals("admin") && password.equals("admin")) {
            Toast.makeText(this, "Вы успешно вошли", Toast.LENGTH_SHORT).show();
            textWelcome.setVisibility(View.VISIBLE);
            editTextLogin.setVisibility(View.GONE);
            editTextPassword.setVisibility(View.GONE);
            buttonLogin.setVisibility(View.GONE);
        } else {
            Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
        }
    }
}
