package ConversorService;


import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Conversor {
    public Conversor() {
    }

    public static NumberFormat seuFormato() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ROOT);
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        return new DecimalFormat("#0.00", symbols);
    }

    public static void main(String[] args) {
        int continuar = 0;

        do {
            Object[] opcoes = new Object[]{"Conversor de Moedas", "Conversor de temperatura"};
            Object opcaoescolhida = JOptionPane.showInputDialog((Component)null, "Escolha o conversor", "Menu", 1, (Icon)null, opcoes, opcoes[0]);
            if (opcaoescolhida == opcoes[0]) {
                Object[] moeda1 = new Object[]{"Reais", "Dólar", "Euro", "Yuan"};
                Object moeda1opcoes = JOptionPane.showInputDialog((Component)null, "Escolha a moeda que vai ser convertida:", "Menu", 1, (Icon)null, moeda1, moeda1[0]);
                String valorinse = JOptionPane.showInputDialog("Insira o valor que deseja converter:");
                if (!valorinse.trim().matches("\\d+")) {
                    JOptionPane.showMessageDialog((Component)null, "Error! Digite um valor numérico!!", "ERROR !", 0);
                } else {
                    double valor = Double.parseDouble(valorinse);
                    Object moeda2opcoes = JOptionPane.showInputDialog((Component)null, "Escolha a moeda que você deseja\nfazer a conversão:", "Menu", 1, (Icon)null, moeda1, moeda1[1]);
                    NumberFormat form;
                    if (moeda1opcoes == moeda1[0] && moeda2opcoes == moeda1[1]) {
                        valor /= 4.73;
                        form = seuFormato();
                        JOptionPane.showMessageDialog((Component)null, "O valor Convertido é EUA " + form.format(valor));
                    } else if (moeda1opcoes == moeda1[0] && moeda2opcoes == moeda1[2]) {
                        valor /= 5.21;
                        form = seuFormato();
                        JOptionPane.showMessageDialog((Component)null, "O valor Convertido é EUR " + form.format(valor));
                    } else if (moeda1opcoes == moeda1[0] && moeda2opcoes == moeda1[3]) {
                        valor *= 1.51;
                        form = seuFormato();
                        JOptionPane.showMessageDialog((Component)null, "O valor Convertido é CNY' " + form.format(valor));
                    }

                    continuar = JOptionPane.showConfirmDialog((Component)null, "Deseja Continuar?");
                }
            }
        } while(continuar == 0);

        JOptionPane.showMessageDialog((Component)null, "Programa finalizado!!");
    }
}

