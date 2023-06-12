package com.example.proyecto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Collections.shuffle(ordenCartas);
		Collections.shuffle(ordenBoton);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	int imagenesDatos[] = {R.drawable.img1,
			   	R.drawable.img2,
	            R.drawable.img3,
	            R.drawable.img4,
	            R.drawable.img5,
	            R.drawable.img6,
	            R.drawable.img7,
	            R.drawable.img8,
	            R.drawable.img9,
	            R.drawable.img10,
	            R.drawable.img11,
	            R.drawable.img12};
	int colorBoton[] = {R.drawable.rojo,
		   	R.drawable.amarillo,
            R.drawable.verde,
            R.drawable.azul,
            R.drawable.negro};
	String color[] = {"verde","azul","rojo","negro","amarillo","rojo",
			"azul","verde","rojo","azul","negro","amarillo"};
	String btncolor[] = {"rojo","amarillo","verde","azul","negro"};
	List<Integer> ordenCartas = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11);
	List<Integer> ordenBoton = Arrays.asList(0,1,2,3,4);
	
	
	int ca = 0;
	int cn = 0;
	int pos = 0;
	int pb=0;
	String cbtn = "";
	String tipo = "";
	private CountDownTimer count; 
	
	public void iniciar(View vista){
		final Button bt1 = (Button) findViewById(R.id.button3);
		final Button bt2 = (Button) findViewById(R.id.button4);
		final Button bt3 = (Button) findViewById(R.id.button5);
		final Button bt4 = (Button) findViewById(R.id.button6);
		final Button bt5 = (Button) findViewById(R.id.button7);  
				
		bt1.setEnabled(true);
		bt2.setEnabled(true);
		bt3.setEnabled(true);
		bt4.setEnabled(true);
		bt5.setEnabled(true);
		ca = 0;
		cn = 0;
		pos = 0;
		pb=0;  
		Collections.shuffle(ordenCartas);
		Collections.shuffle(ordenBoton);
		
		TextView msj = (TextView) findViewById(R.id.textView2);
		msj.setText("Aciertos: "+ca+"");
		TextView msj2 = (TextView) findViewById(R.id.textView3);
		msj2.setText("Desaciertos: "+cn+"");
		final ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
			
		bt1.setText(btncolor[ordenBoton.get(0)]);
		bt2.setText(btncolor[ordenBoton.get(1)]);
		bt3.setText(btncolor[ordenBoton.get(2)]);
		bt4.setText(btncolor[ordenBoton.get(3)]);
		bt5.setText(btncolor[ordenBoton.get(4)]);
		
		
		img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
		tipo = color[ordenCartas.get(pos)];
		/*botones de inicio y reinicio*/
		Button iniciar = (Button) findViewById(R.id.button1);
		Button reiniciar = (Button) findViewById(R.id.button2);
		iniciar.setEnabled(false);
		reiniciar.setEnabled(true);
		
		final Button iniciar_r = (Button) findViewById(R.id.button1);
		final Button reiniciar_r = (Button) findViewById(R.id.button2);
		final TextView tv = (TextView) findViewById(R.id.textView1);
		count=new CountDownTimer(30000,1000) {
			@Override
			public void onFinish() {// cuando concluya el proceso
				iniciar_r.setEnabled(true);
				reiniciar_r.setEnabled(false);
				tv.setText("Se acabo el tiempo");
				bt1.setEnabled(false);
				bt2.setEnabled(false);
				bt3.setEnabled(false);
				bt4.setEnabled(false);
				bt5.setEnabled(false);
			}
			@Override
			public void onTick(long arg0) {// cuando haga pausas
				tv.setText("Tiempo: "+arg0/1000); 	
			}
		}.start();  
	}
	public void reiniciar(View vista){		
		if(count != null){
			Button iniciar = (Button) findViewById(R.id.button1);
			Button reiniciar = (Button) findViewById(R.id.button2);
			iniciar.setEnabled(true);
			reiniciar.setEnabled(false);
			TextView msj = (TextView) findViewById(R.id.textView1);
			msj.setText("");
			
			ca = 0;
			cn = 0;
			pos = 0;
			
			TextView time = (TextView) findViewById(R.id.textView1);
			time.setText("0");
			count.cancel();
		}
	}
	public void boton1(View vista){
		String col = btncolor[ordenBoton.get(0)];;
		TextView tv1 = (TextView)findViewById(R.id.textView3);
		//tv1.setText(col);
		final ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
		if (col.equals(tipo)) {
			ca ++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}else{
			cn++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}
		TextView msj = (TextView) findViewById(R.id.textView2);
		msj.setText("Aciertos: "+ca+"");
		TextView msj2 = (TextView) findViewById(R.id.textView3);
		msj2.setText("Desaciertos: "+cn+"");
		Button bt1 = (Button) findViewById(R.id.button3);
		Button bt2 = (Button) findViewById(R.id.button4);
		Button bt3 = (Button) findViewById(R.id.button5);
		Button bt4 = (Button) findViewById(R.id.button6);
		Button bt5 = (Button) findViewById(R.id.button7);
		  
		Collections.shuffle(ordenBoton);
		
		bt1.setText(btncolor[ordenBoton.get(0)]);
		bt2.setText(btncolor[ordenBoton.get(1)]);
		bt3.setText(btncolor[ordenBoton.get(2)]);
		bt4.setText(btncolor[ordenBoton.get(3)]);
		bt5.setText(btncolor[ordenBoton.get(4)]);
		
	}
	public void boton2(View vista){
		String col = btncolor[ordenBoton.get(1)];;
		TextView tv1 = (TextView)findViewById(R.id.textView3);
		//tv1.setText(col);
		final ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
		if (col.equals(tipo)) {
			ca ++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}else{
			cn++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}
		TextView msj = (TextView) findViewById(R.id.textView2);
		msj.setText("Aciertos: "+ca+"");
		TextView msj2 = (TextView) findViewById(R.id.textView3);
		msj2.setText("Desaciertos: "+cn+"");
		Button bt1 = (Button) findViewById(R.id.button3);
		Button bt2 = (Button) findViewById(R.id.button4);
		Button bt3 = (Button) findViewById(R.id.button5);
		Button bt4 = (Button) findViewById(R.id.button6);
		Button bt5 = (Button) findViewById(R.id.button7);
		  
		Collections.shuffle(ordenBoton);
		
		bt1.setText(btncolor[ordenBoton.get(0)]);
		bt2.setText(btncolor[ordenBoton.get(1)]);
		bt3.setText(btncolor[ordenBoton.get(2)]);
		bt4.setText(btncolor[ordenBoton.get(3)]);
		bt5.setText(btncolor[ordenBoton.get(4)]);
	}
	public void boton3(View vista){
		String col = btncolor[ordenBoton.get(2)];;
		TextView tv1 = (TextView)findViewById(R.id.textView3);
		//tv1.setText(col);
		final ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
		if (col.equals(tipo)) {
			ca ++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}else{
			cn++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}
		TextView msj = (TextView) findViewById(R.id.textView2);
		msj.setText("Aciertos: "+ca+"");
		TextView msj2 = (TextView) findViewById(R.id.textView3);
		msj2.setText("Desaciertos: "+cn+"");
		Button bt1 = (Button) findViewById(R.id.button3);
		Button bt2 = (Button) findViewById(R.id.button4);
		Button bt3 = (Button) findViewById(R.id.button5);
		Button bt4 = (Button) findViewById(R.id.button6);
		Button bt5 = (Button) findViewById(R.id.button7);
		  
		Collections.shuffle(ordenBoton);
		
		bt1.setText(btncolor[ordenBoton.get(0)]);
		bt2.setText(btncolor[ordenBoton.get(1)]);
		bt3.setText(btncolor[ordenBoton.get(2)]);
		bt4.setText(btncolor[ordenBoton.get(3)]);
		bt5.setText(btncolor[ordenBoton.get(4)]);
	}
	public void boton4(View vista){
		String col = btncolor[ordenBoton.get(3)];;
		TextView tv1 = (TextView)findViewById(R.id.textView3);
		//tv1.setText(col);
		final ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
		if (col.equals(tipo)) {
			ca ++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}else{
			cn++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}
		TextView msj = (TextView) findViewById(R.id.textView2);
		msj.setText("Aciertos: "+ca+"");
		TextView msj2 = (TextView) findViewById(R.id.textView3);
		msj2.setText("Desaciertos: "+cn+"");
		Button bt1 = (Button) findViewById(R.id.button3);
		Button bt2 = (Button) findViewById(R.id.button4);
		Button bt3 = (Button) findViewById(R.id.button5);
		Button bt4 = (Button) findViewById(R.id.button6);
		Button bt5 = (Button) findViewById(R.id.button7);
		  
		Collections.shuffle(ordenBoton);
		
		bt1.setText(btncolor[ordenBoton.get(0)]);
		bt2.setText(btncolor[ordenBoton.get(1)]);
		bt3.setText(btncolor[ordenBoton.get(2)]);
		bt4.setText(btncolor[ordenBoton.get(3)]);
		bt5.setText(btncolor[ordenBoton.get(4)]);
	}
	public void boton5(View vista){  
		String col = btncolor[ordenBoton.get(4)];;
		TextView tv1 = (TextView)findViewById(R.id.textView3);
		//tv1.setText(col);
		final ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
		if (col.equals(tipo)) {
			ca ++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}else{
			cn++;
			pos++;
			img.setImageResource(imagenesDatos[ordenCartas.get(pos)]);
			tipo = color[ordenCartas.get(pos)];
		}
		TextView msj = (TextView) findViewById(R.id.textView2);
		msj.setText("Aciertos: "+ca+"");
		TextView msj2 = (TextView) findViewById(R.id.textView3);
		msj2.setText("Desaciertos: "+cn+"");
		Button bt1 = (Button) findViewById(R.id.button3);
		Button bt2 = (Button) findViewById(R.id.button4);
		Button bt3 = (Button) findViewById(R.id.button5);
		Button bt4 = (Button) findViewById(R.id.button6);
		Button bt5 = (Button) findViewById(R.id.button7);
		  
		Collections.shuffle(ordenBoton);
		
		bt1.setText(btncolor[ordenBoton.get(0)]);
		bt2.setText(btncolor[ordenBoton.get(1)]);
		bt3.setText(btncolor[ordenBoton.get(2)]);
		bt4.setText(btncolor[ordenBoton.get(3)]);
		bt5.setText(btncolor[ordenBoton.get(4)]);
	}

}
