package com.ibk.services.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibk.services.model.Usuario;
import com.ibk.services.repository.UsuarioRepository;

@RestController
@RequestMapping(path = "/kpiclientes")
public class KpiController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("promedioClientes")
    public double promedioClientes() {
    	List<Usuario> arr = repository.findAll();
    	int [ ] v = new int [ arr.size() ];
    	for (int j = 0; j < v.length; j++) {
			v[j] = arr.get(j).getEdad();
		}
        return promedio(v);
    }
    
    @GetMapping("desviacionEstandarClientes")
    public double desviacionEstandarClientes() {
    	List<Usuario> arr = repository.findAll();
    	int [ ] v = new int [ arr.size() ];
    	for (int j = 0; j < v.length; j++) {
			v[j] = arr.get(j).getEdad();
		}
        return desviacion(v);
    }

    @GetMapping("/listclientes")
    public Iterable<Usuario> listClientes() {
    	
    	//Formula aleatoria
    	List<Usuario> arr = repository.findAll();
    	int [ ] v = new int [ arr.size() ];
    	for (int j = 0; j < v.length; j++) {
			v[j] = arr.get(j).getEdad();
		}
    	
    	double desviacion = desviacion(v);
    	double promedioVidaPeru = 74.98;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    	Random aleatorio = new Random();
    	Date nuevaFecha = new Date();
    	for (Usuario usuario : arr) {
    		Calendar cal = Calendar.getInstance(); 
            try {
				cal.setTime(sdf.parse(usuario.getFecha_nacimiento()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            
            int anos = (int) (desviacion+aleatorio.nextInt( (int) ((promedioVidaPeru+1) - desviacion)));
            cal.add(Calendar.YEAR, anos);
            
            int dias = (int) (1+aleatorio.nextInt( (int) ((desviacion+1) - 1)));
            cal.add(Calendar.DAY_OF_YEAR, dias);
            
            int meses = (int) (1+aleatorio.nextInt( (int) ((12+1) - 1)));
            cal.set(Calendar.MONTH, meses);
            nuevaFecha = cal.getTime();
            
            usuario.setFecha_muerte(sdf.format(nuevaFecha));
		}
    	
        return arr;
    }
    
    public static double promedio ( int [ ] v ) {
        double prom = 0.0;
        for ( int i = 0; i < v.length; i++ )
          prom += v[i];
        return prom / ( double ) v.length;  
      }
    
    public static double desviacion ( int [ ] v ) {
        double prom, sum = 0; int i, n = v.length;
        prom = promedio ( v );
        for ( i = 0; i < n; i++ ) 
          sum += Math.pow ( v [ i ] - prom, 2 );
        return Math.sqrt ( sum / ( double ) n );
      }

}