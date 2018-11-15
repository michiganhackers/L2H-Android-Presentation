package org.michiganhackers.l2h_demo_app;

import android.content.DialogInterface;
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

    private ListView todoListView;
    private ArrayAdapter<String> todoListAdapter;
    private List<String> todoListItems;
    private FloatingActionButton addItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemButton = findViewById(R.id.addItemFAB);

        todoListView = findViewById(R.id.todoListView);
        todoListItems = new ArrayList<>();
        todoListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoListItems);
        todoListView.setAdapter(todoListAdapter);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddItemDialog();
            }
        });

        todoListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                openRemoveItemDialog(i);
                return true;
            }
        });

        addItemButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                openClearItemsDialog();
                return true;
            }
        });
    }

    private void openAddItemDialog(){
        AlertDialog.Builder addItemAlert = new AlertDialog.Builder(MainActivity.this);
        addItemAlert.setTitle("Add Item");

        final EditText input = new EditText(MainActivity.this);
        addItemAlert.setView(input);

        addItemAlert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String item = input.getText().toString();
                addItem(item);
            }
        });

        addItemAlert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        addItemAlert.show();
    }

    private void addItem(String item){
        todoListItems.add(item);
        todoListAdapter.notifyDataSetChanged();
    }

    private void openRemoveItemDialog(final int position) {
        AlertDialog.Builder addItemAlert = new AlertDialog.Builder(MainActivity.this);
        addItemAlert.setTitle("Delete Item");

        addItemAlert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                removeItem(position);
            }
        });

        addItemAlert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        addItemAlert.show();
    }

    private void removeItem(int pos){
        todoListItems.remove(pos);
        todoListAdapter.notifyDataSetChanged();
    }

    private void openClearItemsDialog(){
        AlertDialog.Builder addItemAlert = new AlertDialog.Builder(MainActivity.this);
        addItemAlert.setTitle("Clear All Items");

        addItemAlert.setPositiveButton("Clear", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                clearItems();
            }
        });

        addItemAlert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        addItemAlert.show();
    }
    private void clearItems(){
        todoListItems.clear();
        todoListAdapter.notifyDataSetChanged();
    }
}
