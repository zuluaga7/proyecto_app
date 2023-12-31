package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.example.utilidades.Utilidad;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionAfiliado {
    Utilidad utilidad = new Utilidad(); // inyeccion de dependencias, una clase llame a otra

    public ValidacionAfiliado() {
    }

    public Boolean validarId(Integer id) throws Exception {
        if (id < 0) {
            throw new Exception(Mensajes.ID_NEGATIVO.getMensaje());
        }
        String expresionRegular = "^[1-9][0-9]*$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular, String.valueOf(id))) {
            throw new Exception("revise el formato ingresado");
        }
        return true;
    }

    public Boolean validarNombres(String nombre) throws Exception {
        //longitud sea menos a 3 y mayor a 40
        if (nombre.length() < 3 || nombre.length() > 40) {
            throw new Exception(Mensajes.NOMBRES_LONGITUD.getMensaje());

        }
        //el formato del nombre tiene numeros o caracteres especiales
        String expresionRegular = "^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular, nombre)) {
            throw new Exception(Mensajes.NOMBRES_FORMATO.getMensaje());


            // busco la coincidencia entre la expresion regular y mi string

        /*Pattern patron=Pattern.compile(expresionRegular);
        Matcher coincidencia=patron.matcher(nombre);
        if(coincidencia.matches()){
            System.out.println("Tenemos coincidencia");
            return true;

        }else{
            System.out.println("no tenemos coincidencia");
            return false;
        }
    //return true;*/
        }
        return true;
    }

    public Boolean validarApeliidos(String apellidos) throws Exception {
        if (apellidos.length() < 10 || apellidos.length() > 50) {
            throw new Exception(Mensajes.APELIIDOS_LONGITUD.getMensaje());
        }
        String expresionRegular = "^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular, apellidos)) {
            throw new Exception(Mensajes.APELLIDOS_FORMATO.getMensaje());




        /*Pattern patron=Pattern.compile(expresionRegular);
        Matcher coincidencia=patron.matcher(apellidos);
        if(coincidencia.matches()){
            System.out.println("Tenemos coincidencia");
            return true;

        }else{
            System.out.println("no tenemos coincidencia");
            return false;*/
        }
        return true;


    }

    public Boolean validarDocumento(String documento) throws Exception {
        if (documento.length() < 7 || documento.length() > 10) {
            throw new Exception(Mensajes.DOCUMENTOS_LONGITUD.getMensaje());

        }

        String expresionRegular = "^[0-9]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular, documento)) {
            throw new Exception(Mensajes.DOCUMENTOS_FORMATO.getMensaje());
        }
        return true;

    }



    /*
    public Boolean ValidarFechaNacimiento(LocalDate fechaNacimiento) throws Exception {
        String DATE_PATTERN = "^(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[0-2])[-/](19|20)\\d\\d$";
        String Matcher;
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(fechaNacimiento);
        if (matcher.matches()) {
            int day = Integer.parseInt(matcher.group(1));


            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));

            if (year >= 1900 && year <= 2099) {
                if ((month >= 1 && month <= 12) && (day >= 1 && day <= day(month, year))) {

                }
            }
        }

        return true;
    }

    private int day(int month, int year) {

    }
     */


    public Boolean ValidarCiudad(Integer ciudad) throws  Exception{
        if (ciudad<0 || ciudad>1153){ // lo que no va a hacer
            throw new Exception(Mensajes.CIUDAD_LONGITUD.getMensaje());
        }
        String espresionRegular="^[0-9]+$";
        if (!this.utilidad.buscarCoincidencia(espresionRegular, String.valueOf(ciudad))){
            throw new Exception(Mensajes.CIUDAD_FORMATO.getMensaje());
        }
        return true;


    }
    public Boolean validarDepartamento(Integer departamento) throws Exception{
        if (departamento<0 || departamento>32){
            throw new Exception(Mensajes.DEPARTAMENTO_LONGITUD.getMensaje());
        }
        String espresionRegular="^-?\\d+$";
        if (!this.utilidad.buscarCoincidencia(espresionRegular, String.valueOf(departamento))){
            throw new Exception(Mensajes.DEPARTAMENTO_FORMATO.getMensaje());
        }
        return true;
        //asdasdas
    }
    public Boolean validarCorreoElectronico(String correoElectronico) throws Exception{
        if(correoElectronico.length()<0 || correoElectronico.length()>14){ // acá le digo LO QUE NO DEBE HACER
            throw new Exception(Mensajes.CORREOELECTRONICO_LONGITUD.getMensaje());
        }

    String espresionRegular="^[A-Za-z0-9+_.-]+@(.+)$";
    if(!this.utilidad.buscarCoincidencia(espresionRegular,correoElectronico)){
        throw new Exception(Mensajes.CORREOELECTRONICO_FORMATO.getMensaje());
    }

    return true;
    }

   public Boolean validarTelefono(String telefono) throws Exception{
        //int telefono=Integer.parseInt(telefono);
        if(telefono.length()<10){
            throw new Exception(Mensajes.TELEFONO_LONGITUD.getMensaje());
        }
        String expresionRegular="^[0-9]+$";
        Pattern pattern= Pattern.compile((telefono));
        Matcher matcher= pattern.matcher(telefono);

        return matcher.matches();
    }


   /* public void trabajarFechas(){
        //fecha mas simple
        LocalDate fechaSistema=LocalDate.now();
        System.out.println(fechaSistema);

        //fecha manual
        LocalDate fechaNacimiento=LocalDate.of(1996,11,21);
        System.out.println(fechaNacimiento);

        //usa la clase scammer para pedir mes,año y dia armando la fecha
        Scanner scanner= new Scanner(System.in);
        System.out.print("digite el año: ");
        Integer ano=scanner.nextInt();
        System.out.print("digite el mes: ");
        Integer mes= scanner.nextInt();
        System.out.print("digite el día: ");
        Integer dia= scanner.nextInt();
        LocalDate fechaEspecial=LocalDate.of(ano,mes,dia);
        System.out.println(fechaEspecial);


        //diferencia entre dos fechas
        Long diferenciaFechas = ChronoUnit.YEARS.between(fechaNacimiento,fechaSistema);
        System.out.println(diferenciaFechas);*/
    }


