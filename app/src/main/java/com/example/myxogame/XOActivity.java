package com.example.myxogame;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class XOActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
   int counter = 0;
   int player1 = 0, player2 =0;
    String playedChar = "";
    String[] board = {"","","", "","","","","",""};
    TextView ply1, ply2;
    EditText player1_name, player2_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);
        ply1= findViewById(R.id.player1_score);
        ply2= findViewById(R.id.player2_score);
        player1_name= findViewById(R.id.player1_name);
        player2_name= findViewById(R.id.player2_name);
         button1 = findViewById(R.id.btn_1);
         button2 = findViewById(R.id.btn_2);
         button3 = findViewById(R.id.btn_3);
         button4 = findViewById(R.id.btn_4);
         button5 = findViewById(R.id.btn_5);
         button6 = findViewById(R.id.btn_6);
         button7 = findViewById(R.id.btn_7);
         button8 = findViewById(R.id.btn_8);
         button9 = findViewById(R.id.btn_9);
    }

    public void onButtonClick(View view) {
        Button btn = (Button) view;
        if(!(btn.getText() == "")){
            return;
        }
        btn.setText(playChar());
        int index = Integer.parseInt((String)btn.getTag());
        board[index-1] = playedChar;
        if(counter == 9){
            Toast.makeText(this, "draw", Toast.LENGTH_LONG).show();
            clearBoard();
        }
        else if (checkWinner(playedChar)){
            if(playedChar == "O") {
                Toast.makeText(this, player1_name.getText() + " wins", Toast.LENGTH_LONG).show();
                ply1.setText(++player1+"");
                clearBoard();
            }
            else {
                Toast.makeText(this, player2_name.getText() + " wins", Toast.LENGTH_LONG).show();
                ply2.setText(++player2+"");
                clearBoard();
            }
        }
    }
    private String playChar() {
        if (counter % 2 == 0) {
            playedChar = "O";
        } else {
            playedChar = "X";
        }
        counter++;

        return playedChar;
    }
    private boolean checkWinner(String playedChar) {
        if (board[0] == playedChar && board[1] == playedChar && board[2] == playedChar){
            return true;
        }
        if (board[3] == playedChar && board[4] == playedChar && board[5]==playedChar){
            return true;
        }
        if (board[6] == playedChar && board[7] == playedChar &&  board[8] == playedChar){
            return true;
        }
        if (board[0] == playedChar && board[3] == playedChar && board[6] == playedChar){
            return true;
        }
        if (board[1] == playedChar && board[4] == playedChar && board[7]==playedChar){
            return true;
        }
        if (board[2] == playedChar && board[5] == playedChar && board[8]==playedChar){
            return true;
        }
        if (board[0] == playedChar &&  board[4]==playedChar && board[8] == playedChar){
            return true;
        }
        if (board[2] == playedChar && board[4] == playedChar && board[6] == playedChar){
            return true;
        }
        return false;
    }
    private void clearBoard() {
        board = new String[]{"", "", "", "", "", "", "", "", ""};
        counter = 0;
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        }
    }

