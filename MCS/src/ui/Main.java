package ui;

import model.Mcs;


import java.util.Scanner;
public class Main{

    private Mcs myMcs;
    private Scanner sc;

    /**
     * Método constructor del Main
     */
    public Main(){
        myMcs = new Mcs();
        sc = new Scanner(System.in);
    }
    
    /** 
     * @param args
     */
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
    
    /** 
     * Método que muestra las opciones posibles del menú
     * @return int , opción elegida
     */
    public int showMenu(){
        int option = 0;
        System.out.println(
            "Menú principal, seleccione una opción\n" +
            "(1) Agregar usuario \n" +
            "(2) Agregar playlist \n"+
            "(3) Agregar cancion\n"+
            "(4) Mostrar usuarios\n" +  
            "(5) Mostrar canciones\n" +
            "(6) Mostrar playlist\n" +
            "(7) Añadir canciones a las playlists\n" +
            "(8) Califica una playlist publica\n" +
            "(0) Para salir"
            );
        option= sc.nextInt();
        sc.nextLine();
        return option;
    }
    
    /** 
     * Método que ejecuta la opción deseada
     * @param operation , opción elegida por el usuario
     */
    public void executeOption(int operation){
        switch(operation) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                addUser();
                break;
            case 2:
                int sOption = 0;
                System.out.println("-----------------------------------");
                System.out.println("Que tipo de playlist desea crear?");
                System.out.println("-----------------------------------");
                System.out.println("(1) Publica"+"\n"+
                                    "(2) Privada"+"\n"+
                                    "(3) Restringida");
                sOption = sc.nextInt();
                switch(sOption){
                    case 1:
                        String name = "";
                        if(myMcs.hasPlaylist()){
                            sc.nextLine();
                            System.out.println("Ingrese el nombre de la playlist");
                            name = sc.nextLine();
                            myMcs.createPlaylist(name);
                            System.out.println("-----------------------------");
                            System.out.println("Playlist creada con exito :D");
                            System.out.println("-----------------------------");
                            name = "";
                        }else{
                            System.out.println("Numero máximo de playlists alcanzado");
                        }
                        
                        break;
                    case 2:
                            int control = 0;
                            if(myMcs.hasPlaylist()){
                            sc.nextLine();
                            System.out.println("Ingrese el nombre de la playlist");
                            
                            name = sc.nextLine();
                            System.out.println("Desde que usuario desea crear esta playlist");
                            System.out.println(myMcs.showNames());
                            control = sc.nextInt();
                            sc.nextLine();//Woofer
                            myMcs.createPlaylist(name, myMcs.whoIsThis(myMcs.returnUserName(control)));
                            System.out.println("-----------------------------");
                            System.out.println("Playlist creada con exito :D");
                            System.out.println("-----------------------------");
                            name = "";
                        }else{
                            System.out.println("Numero máximo de playlists alcanzado");
                        }
                        break;
                    case 3:
                        if(myMcs.hasPlaylist()){
                            int[] indexes = new int[5];
                            sc.nextLine();
                            System.out.println("Ingrese el nombre de la playlist");
                            name = sc.nextLine();
                            System.out.println("Que usuarios tienen acceso a esta playlist?");
                            System.out.println(myMcs.showNames());
                            for(int i = 0; i<5; i++){
                                indexes[i] = sc.nextInt()-1;
                            }
                            myMcs.createPlaylist(name, myMcs.restrictedUserArray(indexes));
                            System.out.println("-----------------------------");
                            System.out.println("Playlist creada con exito :D");
                            System.out.println("-----------------------------");
                            name = "";
                        }else{
                            System.out.println("Numero máximo de playlists alcanzado");
                        }
                        break;
                }
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
            case 6:
                System.out.println(myMcs.showPlaylists());
                break;
            case 7:
                addSongToPlaylist();
                break;
            case 8:
                scorePublicPlaylist();
                break;
            
            default:
                System.out.println("Error, opción no válida");
            
            }
    }
    /**
     * Método para calificar una playlist publica
     */
    public void scorePublicPlaylist(){
        int index = 0;
        double score = 0;
        System.out.println("Que playlist desea calificar?");
        System.out.println(myMcs.showPublicPlaylist());
        index = sc.nextInt();
        index = index-1;
        System.out.println("Califica de 1 a 5");
        score = sc.nextDouble();
        myMcs.updateScoreInPPlaylist(myMcs.onlyPublicPlaylistsToScore(), index, score);
        System.out.println("-----------------------------");
        System.out.println("Playlist calificada con exito :D");
        System.out.println("-----------------------------");
    }
    /**
     * Método añadir un usuario
     */
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
            System.out.println("-----------------------------");
            System.out.println("Usuario creado con exito :D");
            System.out.println("-----------------------------");
        }else{
            System.out.println("Numero máximo de usuarios alcanzado");
        }
    }
    /**
     * Método para añadir una canción a una playlist
     */
    private void addSongToPlaylist(){
        int index1, index2, index3;
        System.out.println("Ingrese la playlist a la que quiere añadir canciones");
        System.out.println(myMcs.showPlaylistNames());
        index1 = sc.nextInt();
        System.out.println("Elija la cancion que desea añadir");
        System.out.println(myMcs.showSongNames());
        index2 = sc.nextInt();
        System.out.println("Elija el usuario que desea añadir");
        System.out.println(myMcs.showNames());
        index3 = sc.nextInt();
        myMcs.addToPlaylist(index1, index2, index3);
        System.out.println("-----------------------------");
        System.out.println("Canción añadida con exito :D");
        System.out.println("-----------------------------");
    }
    /**
     * Método para mostrar usuarios
     */
    private void showUsers(){
        System.out.println(myMcs.showUsers());
    }
    /**
     * Método para mostrar canciones
     */
    private void showSongs(){
        System.out.println(myMcs.showSongs());
    }
    /**
     * Método para crear canciones
     */
    private void addSong(){
        
        String songName = "";
        String artistName = "";
        String releasingDate = "";
        String songGender = "";
        int minutes = 0;
        int seconds = 0;
        int option = 0;
        int index = 0;
        System.out.println(myMcs.showNames());
        System.out.println("Ingrese el numero del usuario desde el cual desea crear la cancion");
        index = sc.nextInt();
        
        myMcs.userIndex(index);
        sc.nextLine();//Limpiar woofer
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
            System.out.println("-----------------------------");
            System.out.println("Cancion creada con exito :D");
            System.out.println("-----------------------------");
            myMcs.updateRank(index);
        }else{
            System.out.println("No se pueden agregar mas canciones");
        }
    }
}