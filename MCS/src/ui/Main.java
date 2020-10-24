package ui;

import model.Mcs;


import java.util.Scanner;
public class Main{

    private Mcs myMcs;
    private Scanner sc;

    public Main(){
        myMcs = new Mcs();
        sc = new Scanner(System.in);
    }
    public static void main(String [] args){
        System.out.println("Hola");
        System.out.println("Inicio del codigo");
        int operation = 0;
        Main myMain = new Main();
        do{
            operation = myMain.showMenu();
            myMain.executeOption(operation);
        }while (operation != 0);
    }
    public int showMenu(){
        int option = 0;
        System.out.println(
            "Menú principal, seleccione una opción\n" +
            "(1) Para crear, editar o eliminar un álbum \n" +
            "(2) Para mostrar la información de los albums en la colección \n"+
            "(3) Para agregar una foto a un álbum\n"+
            "(4) Para editar una foto\n" +  
            "(0) Para salir"
            );
        option= sc.nextInt();
        sc.nextLine();
        return option;
    }
    public void executeOption(int operation){
        switch(operation) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                addUser();
                break;
            case 2:
                System.out.println("------------------------");
                addPlaylist();
                System.out.println("------------------------");
                break;
        
            case 3:
                addSong();
                break;
    
            case 4:
                showUsers();
                break;
            case 5:
                showSongs();
                break;
            
            default:
                System.out.println("Error, opción no válida");
            
            }
    }
    private void addUser(){
        String name = "";
        String password = "";
        int age = 0;
        if(myMcs.hasUser()){
            System.out.println("Ingrese el nombre del usuario");
            System.out.println("Nombre");
            name = sc.nextLine();
            System.out.println("Password");
            password = sc.nextLine();
            System.out.println("Edad");
            age = sc.nextInt();
            myMcs.addUser(name, password, age);
        }else{
            System.out.println("");
        }
    }
    private void showUsers(){
        System.out.println(myMcs.showUsers());
    }
    private void showSongs(){
        System.out.println(myMcs.showSongs());
    }
    private void addPlaylist(){
        String name = "";
        String songGender = "";
        int minutes = 0;
        int seconds = 0;
        System.out.println("Nombre");
        name = sc.nextLine();
        System.out.println("Genero");
        songGender = sc.nextLine();
        System.out.println("Minutos");
        minutes = sc.nextInt();
        System.out.println("Segundos");
        seconds = sc.nextInt();

        //myMcs.addPlaylist(name, songGender, minutes, seconds);
    }
    private void addSong(){
        //! Van 2 metodos, actializacion de el rango del usuario
        String songName = "";
        String artistName = "";
        String releasingDate = "";
        String songGender = "";
        int minutes = 0;
        int seconds = 0;
        int option = 0;
        if(myMcs.hasSongs()){
            System.out.println("Ingrese el nombre de la cancion");
            songName = sc.nextLine();
            System.out.println("Ingrese el nombre del artista");
            artistName = sc.nextLine();
            System.out.println("Ingrese la fecha de lanzamiento");
            releasingDate = sc.nextLine();
            System.out.println("Ingrese el tiempo de la cancion, primero los minutos y luego los segundos");
            System.out.println("Ejemplo: 2:34, entonces ingresas primero los minutos y luego los segundos");
            System.out.println("Ingrese los minutos");
            minutes = sc.nextInt();
            System.out.println("Ingrese los segundos");
            seconds = sc.nextInt();
            System.out.println("Ingrese el genero de la cancion entre:");
            System.out.println("(1)ROCK, (2)HIPHOP, (3)CLASICMUSIC, (4)REGGAE, (5)SALSA, (6)METAL");
            option = sc.nextInt();
            switch(option){
                case 1:
                    songGender = "ROCK";
                    break;
                case 2:
                    songGender = "HIPHOP";
                    break;
                case 3:
                    songGender = "CLASICMUSIC";
                    break;
                case 4:
                    songGender = "REGGAE";
                    break;
                case 5:
                    songGender = "SALSA";
                    break;
                case 6:
                    songGender = "METAL";
                    break;
            }
            myMcs.addSongToPool(songName, artistName, releasingDate, minutes, seconds, songGender);
        }else{
            System.out.println("No se pueden agregar mas canciones");
        }
    }
}