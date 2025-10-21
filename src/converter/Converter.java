package converter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Converter extends JFrame {
    
    JPanel panel;
    
    JComboBox combo1, combo2;
    JTextField input;
    JLabel resultLabel, label;
    JPopupMenu popup;
    
    Map<String, Double> hash;
    
    double value, result;
    
    private void makeMenu() {
        JButton menuButton = new JButton("\u2630");
        menuButton.setBounds(0,0,45,45);
        menuButton.setBackground(Color.white);
        menuButton.setFocusPainted(false);
        
        label = new JLabel();
        label.setBounds(50,10,100,20);
        
        menuButton.addActionListener(e -> {
            makePopup();
            popup.show(menuButton, 0, 45);
        });
        
        add(menuButton); add(label);
    }
    
    private void linkedHashes() {
        hash = new LinkedHashMap<>();
        hash.put("Millilitres", 1.0);
        hash.put("Cubic centimetres", 1.0);
        hash.put("Litres", 1000.0);
        hash.put("Cubic metres", 1000000.0);
        hash.put("Teaspoons (US)", 4.92892159375);
        hash.put("Tablespoons (US)", 14.78676478125);
        hash.put("Fluid ounces (US)", 29.5735295625);
        hash.put("Cups (US)", 236.588237);
        hash.put("Pints (US)", 473.176473);
        hash.put("Quarts (US)", 946.352946);
        hash.put("Gallons (US)", 3785.411784);
        hash.put("Cubic inches", 16.387064);
        hash.put("Cubic feet", 28316.846592);
        hash.put("Cubic yards", 764554.857984);
        hash.put("Teaspoons (UK)", 5.91938802083333);
        hash.put("Tablespoons (UK)", 17.7581640625);
        hash.put("Fluid ounces (UK)", 28.4130625);
        hash.put("Pints (UK)", 568.26125);
        hash.put("Quarts (UK)", 1136.5225);
        hash.put("Gallons (UK)", 4546.09);

        hash.put("Nanometres", 1.0);
        hash.put("Microns", 1000.0);
        hash.put("Millimetres", 1000000.0);
        hash.put("Centimetres", 10000000.0);
        hash.put("Metres", 1000000000.0);
        hash.put("Kilometres", 1000000000000.0);
        hash.put("Inches", 25400000.0);
        hash.put("Feet", 304800000.0);
        hash.put("Yards", 914400000.0);
        hash.put("Miles", 1609344000000.0);
        hash.put("Nautical Miles", 1852000000000.0);

        hash.put("Carats", 0.0002);
        hash.put("Milligrams", 0.000001);
        hash.put("Centigrams", 0.00001);
        hash.put("Decigrams", 0.0001);
        hash.put("Grams", 0.001);
        hash.put("Decagrams", 0.01);
        hash.put("Hectograms", 0.1);
        hash.put("Kilograms", 1.0);
        hash.put("Metric tonnes", 1000.0);
        hash.put("Ounces", 0.028349523125);
        hash.put("Pounds", 0.45359237);
        hash.put("Stone", 6.35029318);
        hash.put("Short tons (US)", 907.18474);
        hash.put("Long tons (UK)", 1016.0469088);

        hash.put("Square millimetres", 0.000001);
        hash.put("Square centimetres", 0.0001);
        hash.put("Square metres", 1.0);
        hash.put("Hectares", 10000.0);
        hash.put("Square kilometres", 1000000.0);
        hash.put("Square inches", 0.00064516);
        hash.put("Square feet", 0.09290304);
        hash.put("Square yards", 0.83612736);
        hash.put("Acres", 4046.8564224);
        hash.put("Square miles", 2589988.1103360);

        hash.put("Centimetres per second", 0.036);
        hash.put("Metres per second", 3.6);
        hash.put("Kilometres per hour", 1.0);
        hash.put("Feet per second", 1.09728);
        hash.put("Miles per hour", 1.6092);
        hash.put("Knots", 1.85184);
        hash.put("Mach", 1225.08);

        hash.put("Microseconds", 1.0);
        hash.put("Milliseconds", 1000.0);
        hash.put("Seconds", 1000000.0);
        hash.put("Minutes", 60000000.0);
        hash.put("Hours", 3600000000.0);
        hash.put("Days", 86400000000.0);
        hash.put("Weeks", 604800000000.0);
        hash.put("Years", 31557600000000.0);

        hash.put("Watts", 0.00134102208959503);
        hash.put("Kilowatts", 1.34102208959503);
        hash.put("Horsepower (US)", 1.0);
        hash.put("Foot-pounds/minute", 0.0000303030303030303);
        hash.put("BTUs/minute", 0.0235808900293295);

        hash.put("Bits", 0.000000000000909494701772928);
        hash.put("Bytes", 0.00000000000727595761418343);
        hash.put("Kilobits", 0.000000000909494701772928);
        hash.put("Kibibits", 0.000000000931322574615479);
        hash.put("Kilobytes", 0.00000000727595761418343);
        hash.put("Kibibytes", 0.00000000745058059692383);
        hash.put("Megabits", 0.000000909494701772928);
        hash.put("Mebibits", 0.00000095367431640625);
        hash.put("Megabytes", 0.00000727595761418343);
        hash.put("Mebibytes", 0.00000762939453125);
        hash.put("Gigabits", 0.000909494701772928);
        hash.put("Gibibits", 0.0009765625);
        hash.put("Gigabytes", 0.00727595761418343);
        hash.put("Gibibytes", 0.0078125);
        hash.put("Terabits", 0.909494701772928);
        hash.put("Tebibits", 1.0);
        hash.put("Terabytes", 7.27595761418343);
        hash.put("Tebibytes", 8.0);
        hash.put("Petabits", 909.494701772928);
        hash.put("Pebibits", 1024.0);
        hash.put("Petabytes", 7275.95761418343);
        hash.put("Pebibytes", 8192.0);
        hash.put("Exabits", 909494.701772928);
        hash.put("Exbibits", 1048576.0);
        hash.put("Exabytes", 7275957.61418343);
        hash.put("Exbibytes", 8388608.0);
        hash.put("Zetabits", 909494701.772928);
        hash.put("Zebibits", 1073741824.0);
        hash.put("Zetabytes", 7275957614.18343);
        hash.put("Zebibytes", 8589934592.0);
        hash.put("Yottabit", 909494701772.928);
        hash.put("Yobibits", 1099511627776.0);
        hash.put("Yottabyte", 7275957614183.43);
        hash.put("Yobibytes", 8796093022208.0);

        hash.put("Atmospheres", 1.01325);
        hash.put("Bars", 1.0);
        hash.put("Kilopascals", 0.01);
        hash.put("Millimetres of mercury", 0.001333);
        hash.put("Pascal", 0.00001);
        hash.put("Pounds per square inch", 0.06894757);

        hash.put("Degrees", 0.0174532925199433);
        hash.put("Radians", 1.0);
        hash.put("Gradians", 0.015707963267949);
    }
    
    private void makePopup() {
        String[] categories = {"Volume", "Length", "Weight and Mass", "Temperature", "Energy", "Area", "Speed", "Time", "Power",
            "Data", "Pressure", "Angle"};
        
        String[] volumes = {"Millilitres", "Cubic centimetres", "Litres", "Cubic metres", "Teaspoons (US)", "Tablespoons (US)", "Fluid ounces (US)", "Cups (US)", "Pints (US)", "Quarts (US)", "Gallons (US)", "Cubic inches", "Cubic feet", "Cubic yards", "Teaspoons (UK)", "Tablespoons (UK)", "Fluid ounces (UK)", "Pints (UK)", "Quarts (UK)", "Gallons (UK)"};
        
        String[] lengths = {"Nanometres", "Microns", "Millimetres", "Centimetres", "Metres", "Kilometres", "Inches", "Feet", "Yards",
            "Miles", "Nautical Miles"};
        
        String[] weights = {"Carats", "Milligrams", "Centigrams", "Decigrams", "Grams", "Decagrams", "Hectograms", "Kilograms",
            "Metric tonnes", "Ounces", "Pounds", "Stone", "Short tons (US)", "Long tons (UK)"};
        String[] temps = {"Celcius", "Fahrenheit", "Kelvin"};
        String[] energies = {"Electron volts", "Joules", "Kilojoules", "Thermal calories", "Food calories", "Foot-pounds",
            "British thermal units"};
        String[] areas = {"Square millimetres", "Square centimetres", "Square metres", "Hectares", "Square kilometres",
            "Square inches", "Square feet", "Square yards", "Acres", "Square miles"};
        String[] speeds = {"Centimetres per second", "Metres per second", "Kilometres per hour", "Feet per second", "Miles per hour",
            "Knots", "Mach"};
        String[] times = {"Microseconds", "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Years"};
        String[] powers = {"Watts", "Kilowatts", "Horsepower (US)", "Foot-pounds/minute", "BTUs/minute"};
        String[] datas = {"Bits", "Bytes", "Kilobits", "Kibibits", "Kilobytes", "Kibibytes", "Megabits", "Mebibits", "Megabytes",
            "Mebibytes", "Gigabits", "Gibibits", "Gigabytes", "Gibibytes", "Terabits", "Tebibits", "Terabytes", "Tebibytes",
            "Petabits", "Pebibits", "Petabytes", "Pebibytes", "Exabits", "Exbibits", "Exabytes", "Exbibytes", "Zetabits", "Zebibits",
            "Zetabytes", "Zebibytes", "Yottabit", "Yobibits", "Yottabyte", "Yobibytes"};
        String[] pressures = {"Atmospheres", "Bars", "Kilopascals", "Millimetres of mercury", "Pascal", "Pounds per square inch"}; 
        String[] angles = {"Degrees", "Radians", "Gradians"};
        
        popup = new JPopupMenu();
        
        for(String category: categories) {
            JMenuItem item = new JMenuItem(category);
            item.addActionListener((ActionEvent e) -> {
                label.setText(category);
                if(!panel.isVisible()) {
                    panel.setVisible(true);
                }
                switch(category) {
                    case "Volume" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String v : volumes) {
                            combo1.addItem(v);
                            combo2.addItem(v);
                        }
                    }
                    case "Length" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String length : lengths) {
                            combo1.addItem(length);
                            combo2.addItem(length);
                        }
                    }
                    case "Weight and Mass" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String weight : weights) {
                            combo1.addItem(weight);
                            combo2.addItem(weight);
                        }
                    }
                    case "Temperature" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String temp : temps) {
                            combo1.addItem(temp);
                            combo2.addItem(temp);
                        }
                    }
                    case "Energy" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String energy : energies) {
                            combo1.addItem(energy);
                            combo2.addItem(energy);
                        }
                    }
                    case "Area" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String area : areas) {
                            combo1.addItem(area);
                            combo2.addItem(area);
                        }
                    }
                    case "Speed" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String speed : speeds) {
                            combo1.addItem(speed);
                            combo2.addItem(speed);
                        }
                    }
                    case "Time" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String time : times) {
                            combo1.addItem(time);
                            combo2.addItem(time);
                        }
                    }
                    case "Power" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String power : powers) {
                            combo1.addItem(power);
                            combo2.addItem(power);
                        }
                    }
                    case "Data" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String data : datas) {
                            combo1.addItem(data);
                            combo2.addItem(data);
                        }
                    }
                    case "Pressure" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String pressure : pressures) {
                            combo1.addItem(pressure);
                            combo2.addItem(pressure);
                        }
                    }
                    case "Angle" -> {
                        combo1.removeAllItems();
                        combo2.removeAllItems();
                        
                        for(String angle : angles) {
                            combo1.addItem(angle);
                            combo2.addItem(angle);
                        }
                    }
                    
                    default -> {}
                }
            });
            popup.add(item);
        }
    }
    
    private void makePanel() {
        panel = new JPanel(null);
        panel.setBounds(0,45,317,430);
        panel.setVisible(false);
        
        combo1 = new JComboBox();
        combo1.setBounds(10,100,180,20);
        
        input = new JTextField();
        input.setBounds(10,125,180,20);
        
        combo2 = new JComboBox();
        combo2.setBounds(10,160,180,20);
        
        resultLabel = new JLabel();
        resultLabel.setBounds(10,185,180,20);
        
        panel.add(combo1);
        panel.add(input);
        panel.add(combo2);
        panel.add(resultLabel);
        
        add(panel);
    }
    
    private void displayResult() {
        if(result>9999999 || result<0.001) {
            resultLabel.setText(String.format("%f",result));
        }
        else {
            resultLabel.setText("" + result);
        }
    }
    
    private void displayValue() {
        if(value>9999999 || value<0.001) {
            resultLabel.setText(String.format("%f",value));
        }
        else {
            resultLabel.setText("" + value);
        }
    }
    
    private void convert() {
        linkedHashes();
        
        Timer timer = new Timer();
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    value = Double.parseDouble(input.getText());
                    
                    double x_value = 0, y_value = 0;
                    
                    if(!label.getText().equals("Temperature")) {
                        for(Map.Entry<String, Double> entry : hash.entrySet()) {
                            if(entry.getKey().equals(combo1.getSelectedItem())) {
                                x_value = entry.getValue();
                            }
                            if(entry.getKey().equals(combo2.getSelectedItem())) {
                                y_value = entry.getValue();
                            }
                        }
                        result = (value*x_value)/y_value;
                        displayResult();
                    }
                    else {
                        double x=9, y=5;
                        switch(combo1.getSelectedItem().toString()) {
                            case "Celcius" ->{
                                switch(combo2.getSelectedItem().toString()) {
                                    case "Celcius" -> displayValue();
                                    case "Fahrenheit" -> {
                                        result = (((x/y)*value)+32);
                                        displayResult();
                                    }
                                    case "Kelvin" -> {
                                        result = (value+273.15);
                                        displayResult();
                                    }
                                }
                            }
                            case "Fahrenheit" -> {
                                switch(combo2.getSelectedItem().toString()) {
                                    case "Celcius" -> {
                                        result = (value-32)*(y/x);
                                        displayResult();
                                        }
                                    case "Fahrenheit" -> displayValue();
                                    case "Kelvin" -> {
                                        result = (((value-32)*(y/x))+273.15);
                                        displayResult();
                                    }
                                }
                            }
                            case "Kelvin" -> {
                                switch(combo2.getSelectedItem().toString()) {
                                    case "Celcius" -> {
                                        result = (value-273.15);
                                        displayResult();
                                    }
                                    case "Fahrenheit" -> {
                                        result = (((x/y)*(value-273.15))+32);
                                        displayResult();
                                    }
                                    case "Kelvin" -> displayValue();
                                }
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    resultLabel.setText("");
                }
            }
        };
        timer.schedule(task, 0,60);
    }
    
    public Converter() {
        setSize(335,516);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setTitle("Converter");
        
        makeMenu();
        makePanel();
        convert();
    }
    
    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.setVisible(true);
    }
}