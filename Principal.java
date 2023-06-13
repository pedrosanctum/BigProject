import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Funcionario extends JFrame {

    public static void main(String[] args) {
        Funcionario app = new Funcionario();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final long serialVersionUID = 1L;
    public String codigo;
    public String nomeFunc;
    public String cargo;
    public double salario;
    public String nomeDependente;
    public int totalDependentes;

    public String getCodigo() {
        return codigo;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public int getTotalDependentes() {
        return totalDependentes;
    }

    private JPanel inputDetailJPanel;

    //Código Funcionário
    private JLabel CodigoJLabel;
    private JTextField CodigoJTextField;

    //Nome Funcionário
    private JLabel NomeFuncJLabel;
    private JTextField NomeFuncJTextField;


    //Cargo
    private JLabel CargoJLabel;
    private JTextField CargoJTextField;

    //Salario
    private JLabel SalarioJLabel;
    private JTextField SalarioJTextField;

    //Nome Dependente
    private JLabel nomeDependenteJLabel;
    private JTextField nomeDependenteJTextField;

    //Total Dependentes
    private JLabel TotalDependenteJLabel;
    private JTextField TotalDependenteJTextField;

    //Botões

    private JButton CriarFuncionarioJButton;
    private JButton ApagarFuncionarioJButton;
    private JButton MostrarDadosJButton;
    private JButton ImprimirDadosJButton;
    private JButton AlterarSalarioJButton;

    //Tela Detalhes Funcionários
    private JLabel displayJLabel;
    private static JTextArea displayJTextArea;


    public Funcionario() {
        interfaceUsuario();
    }

    private void interfaceUsuario() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //Layout Empresa
        inputDetailJPanel = new JPanel();
        inputDetailJPanel.setBounds(16, 16, 216, 280);
        inputDetailJPanel.setBorder(new TitledBorder("Empresa"));
        inputDetailJPanel.setLayout(null);
        contentPane.add(inputDetailJPanel);

        //Código - JLabel
        CodigoJLabel = new JLabel();
        CodigoJLabel.setBounds(8, 32, 90, 23);
        CodigoJLabel.setText("Código:");
        inputDetailJPanel.add(CodigoJLabel);

        //Código - JText
        CodigoJTextField = new JTextField();
        CodigoJTextField.setBounds(128, 32, 80, 21);
        CodigoJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(CodigoJTextField);

        //Nome Funcionário - JLabel
        NomeFuncJLabel = new JLabel();
        NomeFuncJLabel.setBounds(8, 56, 124, 23);
        NomeFuncJLabel.setText("Nome Funcionário: ");
        inputDetailJPanel.add(NomeFuncJLabel);

        //Nome Funcionário - JText
        NomeFuncJTextField = new JTextField();
        NomeFuncJTextField.setBounds(128, 56, 80, 21);
        NomeFuncJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(NomeFuncJTextField);

        //Cargo - JLabel
        CargoJLabel = new JLabel();
        CargoJLabel.setBounds(8, 75, 80, 32);
        CargoJLabel.setText("Cargo: ");
        inputDetailJPanel.add(CargoJLabel);

        //Cargo - JTextField
        CargoJTextField = new JTextField();
        CargoJTextField.setBounds(128, 80, 80, 21);
        CargoJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(CargoJTextField);

        //Salario - JLabel
        SalarioJLabel = new JLabel();
        SalarioJLabel.setBounds(8, 104, 80, 23);
        SalarioJLabel.setText("Salário: ");
        inputDetailJPanel.add(SalarioJLabel);

        //Salário - JText
        SalarioJTextField = new JTextField();
        SalarioJTextField.setBounds(128, 104, 80, 21);
        SalarioJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(SalarioJTextField);

        //Nome Dependente - JLabel
        nomeDependenteJLabel = new JLabel();
        nomeDependenteJLabel.setBounds(8, 128, 124, 23);
        nomeDependenteJLabel.setText("Nome Dependente: ");
        inputDetailJPanel.add(nomeDependenteJLabel);

        //Nome Dependente - JText
        nomeDependenteJTextField = new JTextField();
        nomeDependenteJTextField.setBounds(128, 128, 80, 21);
        nomeDependenteJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(nomeDependenteJTextField);

        //Total Dependentes - JLabel
        TotalDependenteJLabel = new JLabel();
        TotalDependenteJLabel.setBounds(8, 152, 124, 21);
        TotalDependenteJLabel.setText("Total Dependente: ");
        inputDetailJPanel.add(TotalDependenteJLabel);

        //Total Dependente - JText
        TotalDependenteJTextField = new JTextField();
        TotalDependenteJTextField.setBounds(128, 152, 80, 21);
        TotalDependenteJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(TotalDependenteJTextField);

        //Ativação Botão Criar
        CriarFuncionarioJButton = new JButton();
        CriarFuncionarioJButton.setBounds(104, 176, 88, 24);
        CriarFuncionarioJButton.setText("Criar");
        inputDetailJPanel.add(CriarFuncionarioJButton);
        CriarFuncionarioJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CriarFuncionarioJButtonAtivacao(e);
                    }
                }
        );

        //Ativação Botão Apagar
        ApagarFuncionarioJButton = new JButton();
        ApagarFuncionarioJButton.setBounds(16, 176, 88, 24);
        ApagarFuncionarioJButton.setText("Apagar");
        inputDetailJPanel.add(ApagarFuncionarioJButton);
        ApagarFuncionarioJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ApagarFuncionarioJButtonAtivacao(e);
                    }
                }
        );

        //Ativação Botão Alterar Salário
        AlterarSalarioJButton = new JButton();
        AlterarSalarioJButton.setBounds(16, 200, 176, 24);
        AlterarSalarioJButton.setText("Alterar Salário");
        inputDetailJPanel.add(AlterarSalarioJButton);
        AlterarSalarioJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            AlterarSalarioJButtonAtivacao(e);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );

        //Ativação Botão Mostrar Dados
        MostrarDadosJButton = new JButton();
        MostrarDadosJButton.setBounds(16, 224, 176, 24);
        MostrarDadosJButton.setText("Mostrar Dados");
        inputDetailJPanel.add(MostrarDadosJButton);
        MostrarDadosJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MostrarDadosJButtonAtivacao(e);
                    }
                }
        );
        //Ativação Botão Imprimir Dados
        ImprimirDadosJButton = new JButton();
        ImprimirDadosJButton.setBounds(16, 248, 176, 24);
        ImprimirDadosJButton.setText("Imprimir Dados");
        inputDetailJPanel.add(ImprimirDadosJButton);
        ImprimirDadosJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ImprimirDadosJButtonAtivacao(e);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        //Criação do expositor de dados
        displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 220, 23);
        displayJLabel.setText("Informações dos Funcionários: ");
        contentPane.add(displayJLabel);

        //Criação da área dos Textos
        displayJTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayJTextArea);
        scrollPane.setBounds(240, 48, 424, 184);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
        displayJTextArea.setText("Seja bem vindo! No momento não há funcionários cadastrados.");

        //Informações a serem mostradas
        CodigoJTextField.setText("");
        NomeFuncJTextField.setText("");
        CargoJTextField.setText("");
        SalarioJTextField.setText("0");
        nomeDependenteJTextField.setText("");
        TotalDependenteJTextField.setText("0");

        //Informações Janela
        setTitle("Gerenciamento de Pessoas");
        setSize(680, 332);
        setVisible(true);
    }

    //Array List Funcionarios
    ArrayList<DadosFuncionario> Funcionarios = new ArrayList<>();
    ArrayList<Dependentes> DependentesDados = new ArrayList<>();

    //Hash Set Funcionarios
    HashSet<DadosFuncionario> set = new HashSet<>();

    private void CriarFuncionarioJButtonAtivacao(ActionEvent e) {
        displayJTextArea.setText("");

        codigo = "";
        nomeFunc = "";
        cargo = "";
        salario = 0;
        nomeDependente = "";
        totalDependentes = 0;

        codigo = CodigoJTextField.getText();
        nomeFunc = NomeFuncJTextField.getText();
        cargo = CargoJTextField.getText();
        salario = Double.parseDouble(SalarioJTextField.getText());
        nomeDependente = nomeDependenteJTextField.getText();
        totalDependentes = Integer.parseInt(TotalDependenteJTextField.getText());

        Funcionarios.forEach(value -> {
            if(value.getCodigo().equals(codigo)){
                throw new IllegalArgumentException("Código já existente!");
            }
        });
        try {
            if (SalarioJTextField.getText() == "0") {
                salario = 0;
            } else {
                salario = Double.parseDouble(SalarioJTextField.getText());
            }
        } catch (NumberFormatException ex) {
            System.err.println("O número digitado deve ser separado com . invés de ,");
        }

        try {
            if ((codigo != "") & (nomeFunc != "")) {
                Funcionarios.add(new DadosFuncionario(codigo, nomeFunc, cargo, salario, nomeDependente, totalDependentes));
                DadosFuncionario dadoTemp = (DadosFuncionario) Funcionarios.get(Funcionarios.size() - 1);
                displayJTextArea.setText("Funcionário: " + Funcionarios.size() + "\n Codigo: " + dadoTemp.getCodigo() + "\n Nome: " + dadoTemp.getNome() +
                        "\n Cargo: " + dadoTemp.getCargo() + "\n Salário: R$ " + dadoTemp.getSalario() + "\n Dependentes: " + dadoTemp.getTotalDependentes() + "\n Nome: " + dadoTemp.getNomeDependentes());
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private void ApagarFuncionarioJButtonAtivacao(ActionEvent e) {

        if (Funcionarios.size() == 0) {
            displayJTextArea.setText("Sem funcionários cadastrados!");
        }else{
            String codigoFunc = CodigoJTextField.getText();
            for(int i = 0; i < Funcionarios.size();i++){
                DadosFuncionario dadoTemp = (DadosFuncionario) Funcionarios.get(i);
                if((dadoTemp.getCodigo().equals(codigoFunc))){
                    Funcionarios.remove(i);
                }
                displayJTextArea.setText("Funcionario "+dadoTemp.getNome()+ "-"+ codigoFunc +" apagado!");
            }
        }


        CodigoJTextField.setText("");
        NomeFuncJTextField.setText("");
        CargoJTextField.setText("");
        SalarioJTextField.setText("0");
        nomeDependenteJTextField.setText("");
        TotalDependenteJTextField.setText("0");


    }

    private void MostrarDadosJButtonAtivacao(ActionEvent e) {
        codigo = CodigoJTextField.getText();
        displayJTextArea.setText("");

        if (Funcionarios.isEmpty()) {
            displayJTextArea.setText("Não há funcionários cadastrados!");
        } else {
            for (int i = 0; i < Funcionarios.size(); i++) {
                DadosFuncionario dadoTemp = (DadosFuncionario) Funcionarios.get(i);
                displayJTextArea.append("Funcionário: " + "\n Codigo: " + dadoTemp.getCodigo() + "\n Nome: " + dadoTemp.getNome() +
                        "\n Cargo: " + dadoTemp.getCargo() + "\n Salário: R$ " + dadoTemp.getSalario() + "\n Nome Dependente(s): " + dadoTemp.getNomeDependentes() +
                        "\n Dependente(s): " + dadoTemp.getTotalDependentes() + "\n Bônus no Salário: "+ (dadoTemp.getSalario() * 0.02 * dadoTemp.getTotalDependentes())+"\n------------------------\n");

            }
        }
        CodigoJTextField.setText("");
        NomeFuncJTextField.setText("");
        CargoJTextField.setText("");
        SalarioJTextField.setText("0");
        nomeDependenteJTextField.setText("");
        TotalDependenteJTextField.setText("0");
    }

    private void AlterarSalarioJButtonAtivacao(ActionEvent e) throws IOException {

        displayJTextArea.setText("");
        if (Funcionarios.size() == 0) {
            displayJTextArea.setText("Não há funcionários cadastrados!");
        } else {
            double SalarioFuncionario = Double.parseDouble(SalarioJTextField.getText());
            String CodigoFuncionario = CodigoJTextField.getText();
            for (int i = 0; i < Funcionarios.size(); i++) {
                DadosFuncionario dadoTemp = (DadosFuncionario) Funcionarios.get(i);
                if ((dadoTemp.codigo.equals(CodigoFuncionario)) && (SalarioFuncionario > 0))
                    dadoTemp.setSalario((Double.parseDouble(SalarioJTextField.getText())));
                Funcionarios.set(i, dadoTemp);
                displayJTextArea.setText("O novo salário do Funcionário: " + dadoTemp.getCodigo() + " - " + dadoTemp.getNome() + " é de R$ " + dadoTemp.getSalario());
            }
        }
    }
    private void ImprimirDadosJButtonAtivacao(ActionEvent e) throws IOException {

        File f1 = new File("ListaFuncionarios.txt");
        FileWriter fw = new FileWriter(f1.getName(), true);
        BufferedWriter out = new BufferedWriter(fw);

        Funcionarios.forEach((funcionario) -> {
            try {
                out.append("/------------------------------/");
                out.append("\nNome Funcionário: ").append(funcionario.getNome());
                out.append("\nCódigo: ").append(funcionario.getCodigo());
                out.append("\nCargo: ").append(funcionario.getCargo());
                out.append("\nSalario: ").append(String.valueOf(funcionario.getSalario()));
                out.append("\nDependentes: ").append(String.valueOf(funcionario.getTotalDependentes()));
                out.append("\nNome Dependente: ").append(funcionario.getNomeDependentes());
                out.append("\nBônus no Salário: ").append(String.valueOf(getSalario() * 0.02 * getTotalDependentes()));
                out.append("\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        out.close();
    }
}


