package org.michiganhackers.l2h_demo_app;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> todoListAdapter;
    private List<String> todoListItems;
    private List<Integer> todoListStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton todoListAddItemButton = findViewById(R.id.addTodoItemButton);

        ListView todoListView = findViewById(R.id.todoList);
        todoListItems = new ArrayList<>();
        todoListStates = new ArrayList<>();
        todoListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoListItems);
        todoListView.setAdapter(todoListAdapter);

        todoListAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTodoListAddItemDialog();
            }
        });

        todoListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                openTodoListItemLongClickDialog(i);
                return true;
            }
        });

        todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (todoListStates.get(i) == 0) {
                    view.setBackgroundColor(Color.GREEN);
                    todoListStates.set(i, 1);
                }
                else{
                    view.setBackgroundColor(Color.WHITE);
                    todoListStates.set(i, 0);
                }
            }
        });

    }

    private void openTodoListAddItemDialog(){
        AlertDialog.Builder addItemAlert = new AlertDialog.Builder(MainActivity.this);
        addItemAlert.setTitle("Add an item to your todo list");

        final EditText input = new EditText(MainActivity.this);
        addItemAlert.setView(input);

        addItemAlert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String item = input.getText().toString();
                addItemTodoList(item);
            }
        });

        addItemAlert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        addItemAlert.show();
    }

    private void openTodoListItemLongClickDialog(final int position) {
        AlertDialog.Builder addItemAlert = new AlertDialog.Builder(MainActivity.this);
        addItemAlert.setTitle("Delete an item from your todo list");

        addItemAlert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                removeItemTodoList(position);
            }
        });

        addItemAlert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        addItemAlert.show();
    }

    private void addItemTodoList(String item){
        todoListItems.add(item);
        todoListStates.add(0);
        todoListAdapter.notifyDataSetChanged();
    }
    private void removeItemTodoList(int pos){
        todoListItems.remove(pos);
        todoListStates.remove(pos);
        todoListAdapter.notifyDataSetChanged();

    }
}
