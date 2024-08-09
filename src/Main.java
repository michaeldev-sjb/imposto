import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double annualSalary = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double serviceProvision = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital:  ");
        double capitalGain = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double medicalExpenses = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double educationalExpenses = sc.nextDouble();

        double monthlySalary = annualSalary / 12;
        double taxSalary = 0.0;

        if (monthlySalary > 5000.00) {
            taxSalary = annualSalary * 0.20;
        }else if (monthlySalary > 3000 && monthlySalary <= 5000) {
            taxSalary = annualSalary * 0.10;
        }

        double taxService = 0.0;
        if (serviceProvision > 0) {
            taxService = serviceProvision * 0.15;
        }

        double taxCapital = 0.0;
        if (capitalGain > 0) {
            taxCapital = capitalGain * 0.20;
        }

        double maxDeductible = (taxSalary + taxService + taxCapital) * 0.30;

        double deductibleExpenses = medicalExpenses + educationalExpenses;

        double grossTax = taxSalary + taxService + taxCapital;

        double abatement = (maxDeductible > deductibleExpenses) ? deductibleExpenses : maxDeductible;

        double taxDue = grossTax - abatement;

        System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA\n");

        System.out.println("CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f%n", taxSalary);
        System.out.printf("Imposto sobre serviços: %.2f%n", taxService);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n%n", taxCapital);

        System.out.println("DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f%n", maxDeductible);
        System.out.printf("Gastos dedutíveis: %.2f%n%n", deductibleExpenses);

        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", grossTax);
        System.out.printf("Abatimento: %.2f%n", abatement);
        System.out.printf("Imposto devido: %.2f%n%n", taxDue);
    
        





        sc.close();

    }
}
