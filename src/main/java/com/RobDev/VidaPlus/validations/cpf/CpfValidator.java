package com.RobDev.VidaPlus.validations.cpf;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CpfValid, String> {
    @Override
    public void initialize(CpfValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if(cpf == null || !cpf.matches("^[0-9]{11}$")) return false;
        int digit10 = CheckDigit(10, cpf);
        int digit11 = CheckDigit(11, cpf);

        boolean cond1 = digit10 == Integer.parseInt(String.valueOf(cpf.charAt(9))); // verifica se o penultimo numéro é verdadeiro
        boolean cond2 = digit11 == Integer.parseInt(String.valueOf(cpf.charAt(10))); // verifica se o ultimo numéro é verdadeiro

        return cond1 && cond2;
    }

    public int CheckDigit(int quantity, String cpf){
        int sum = 0;
        int value = quantity; // multiplicador em ordem decrescente

        for(int i =0; i< quantity - 1; i++){
            String oneNumberCPF = String.valueOf(cpf.charAt(i)); // pega só um número do cpf por vez
            sum += Integer.parseInt(oneNumberCPF) * value--; // realiza o calculo do dígito
        }

        sum = sum % 11;

        return sum < 2 ? 0 : 11 - sum;
    }
}
