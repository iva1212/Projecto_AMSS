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
    
     public static String Lion="-fx-background-color: \n" +
"        rgba(0,0,0,0.08),\n" +
"        linear-gradient(#9a9a9a, #909090),\n" +
"        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n" +
"    -fx-background-insets: 0 0 -1 0,0,1;\n" +
"    -fx-background-radius: 5,5,4;\n" +
"    -fx-padding: 3 30 3 30;\n" +
"    -fx-text-fill: #242d35;\n" +
"    -fx-font-size: 14px;\n";
      public static String Lion_Red="-fx-background-color: \n" +
"        rgba(0,0,0,0.08),\n" +
"        linear-gradient(#9a9a9a, #909090),\n" +
"        linear-gradient(white 0%, #FF6464 50%, #EC9696 51%, #F25A5A 100%);\n" +
"    -fx-background-insets: 0 0 -1 0,0,1;\n" +
"    -fx-background-radius: 5,5,4;\n" +
"    -fx-padding: 3 30 3 30;\n" +
"    -fx-text-fill: #242d35;\n" +
"    -fx-font-size: 14px;\n";
     public static String Lion_default="-fx-background-color: \n" +
"        rgba(0,0,0,0.08),\n" +
"        linear-gradient(#5a61af, #51536d),\n" +
"        linear-gradient(#e4fbff 0%,#cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
"    -fx-background-insets: 0 0 -1 0,0,1;\n" +
"    -fx-background-radius: 5,5,4;\n" +
"    -fx-padding: 3 30 3 30;\n" +
"    -fx-text-fill: #242d35;\n" +
"    -fx-font-size: 14px;";
     public static String Lion_default_Red="-fx-background-color: \n" +
"        rgba(0,0,0,0.08),\n" +
"        linear-gradient(#5a61af, #51536d),\n" +
"        linear-gradient(#FFE4E4 0%,#FBCECE 10%, #FBA5A5 50%, #FB8888 51%, #FFD5D5 100%);\n" +
"    -fx-background-insets: 0 0 -1 0,0,1;\n" +
"    -fx-background-radius: 5,5,4;\n" +
"    -fx-padding: 3 30 3 30;\n" +
"    -fx-text-fill: #242d35;\n" +
"    -fx-font-size: 14px;";
     
     public static String Montserrat_Light=" -fx-font-family: \"Montserrat-Light\";\n" +
"    -fx-font-size: 20;\n"+"-fx-font-weight: bold;";
     public static String  Styled_Select="background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;\n" +
"   height: 29px;\n" +
"   overflow: hidden;\n" +
"   width: 240px;";
     public static String Rich_Blue="-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(#7ebcea, #2f4b8f),\n" +
"        linear-gradient(#426ab7, #263e75),\n" +
"        linear-gradient(#395cab, #223768);\n" +
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 12px;\n"+
             "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);\n"+"-fx-font-size: 20;";
     public static String Rich_Blue_Default="-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(#7ebcea, #2f4b8f),\n" +
"        linear-gradient(#426ab7, #263e75),\n" +
"        linear-gradient(#395cab, #223768);\n" +
"        -fx-background-color: linear-gradient(#2A5058, #61a2b1);"+
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 12px;\n"+
             "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);\n"+"-fx-font-size: 20;";
     
     public static String Skip="-fx-background-color: #8c9cbf;\n" +
"  -fx-background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #8c9cbf), color-stop(50%, #546a9e), color-stop(50%, #36518f), color-stop(100%, #3d5691));\n" +
"  -fx-background-image: -webkit-linear-gradient(top, #8c9cbf 0%, #546a9e 50%, #36518f 50%, #3d5691 100%);\n" +
"  -fx-background-image: -moz-linear-gradient(top, #8c9cbf 0%, #546a9e 50%, #36518f 50%, #3d5691 100%);\n" +
"  -fx-background-image: -ms-linear-gradient(top, #8c9cbf 0%, #546a9e 50%, #36518f 50%, #3d5691 100%);\n" +
"  -fx-background-image: -o-linear-gradient(top, #8c9cbf 0%, #546a9e 50%, #36518f 50%, #3d5691 100%);\n" +
"  -fx-background-image: linear-gradient(top, #8c9cbf 0%, #546a9e 50%, #36518f 50%, #3d5691 100%);\n" +
"  -fx-border: 1px solid #172d6e;\n" +
"  -fx-border-bottom: 1px solid #0e1d45;\n" +
"  -fx-border-radius: 5px;\n" +
"  -fx-webkit-box-shadow: inset 0 1px 0 0 #b1b9cb;\n" +
"  -fx-box-shadow: inset 0 1px 0 0 #b1b9cb;\n" +
"  -fx-color: #fff;\n" +
"  -fx-font: bold 16px/1 \"helvetica neue\", helvetica, arial, sans-serif;\n" +
"  -fx-padding: 7px 0 8px 0;\n" +
"  -fx-text-decoration: none;\n" +
"  -fx-text-align: center;\n" +
"  -fx-text-shadow: 0 -1px 1px #000f4d;\n" +
"  -fx-width: 150px;";
    public static String Skip_Hover="ackground-color: #7f8dad;\n" +
"    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #7f8dad), color-stop(50%, #4a5e8c), color-stop(50%, #2f477d), color-stop(100%, #364c80));\n" +
"    background-image: -webkit-linear-gradient(top, #7f8dad 0%, #4a5e8c 50%, #2f477d 50%, #364c80 100%);\n" +
"    background-image: -moz-linear-gradient(top, #7f8dad 0%, #4a5e8c 50%, #2f477d 50%, #364c80 100%);\n" +
"    background-image: -ms-linear-gradient(top, #7f8dad 0%, #4a5e8c 50%, #2f477d 50%, #364c80 100%);\n" +
"    background-image: -o-linear-gradient(top, #7f8dad 0%, #4a5e8c 50%, #2f477d 50%, #364c80 100%);\n" +
"    background-image: linear-gradient(top, #7f8dad 0%, #4a5e8c 50%, #2f477d 50%, #364c80 100%);\n" +
"    cursor: pointer;";
}
