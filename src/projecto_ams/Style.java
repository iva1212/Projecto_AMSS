/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

/**
 *
 * @author ivann
 */
public class Style {

    public Style() {
    }
    
    /**
     *Set style of button to one similar to windows 7
     */
    public static String Windows7="-fx-background-color: \n" +
"        #707070,\n" +
"        linear-gradient(#fcfcfc, #f3f3f3),\n" +
"        linear-gradient(#f2f2f2 0%, #ebebeb 49%, #dddddd 50%, #cfcfcf 100%);\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-background-radius: 3,2,1;\n" +
"    -fx-padding: 3 30 3 30;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-font-size: 14px;";
    public static String Windows7_default="-fx-background-color: \n" +
"        #3c7fb1,\n" +
"        linear-gradient(#fafdfe, #e8f5fc),\n" +
"        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-background-radius: 3,2,1;\n" +
"    -fx-padding: 3 30 3 30;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-font-size: 14px;";
    public static String Green=" -fx-background-color:\n" +
"        linear-gradient(#f0ff35, #a9ff00),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
"    -fx-background-radius: 6, 5;\n" +
"    -fx-background-insets: 0, 1;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
"    -fx-text-fill: #395306;";
    public static String RoundRed="-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0;\n" +
"    -fx-text-fill: white;";
    public static String BevelGrey="-fx-background-color: \n" +
"        linear-gradient(#f2f2f2, #d6d6d6),\n" +
"        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
"        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
"    -fx-background-radius: 8,7,6;\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
    
}
