package api.domain.mask;

public class Mascara {
    public static String maskTelefone(String telefone){
        return telefone.replaceFirst("^\\(?[1-9]{2}\\)[0-9]{4,5}-[0-9]{1}", "(**)*****-*");
    }

    public static String maskEmail(String email){
        return email.replaceFirst("(?<=^.{2}).(?=[^@]*@)[a-z0-9.]++", "******");
    }

    public static String maskCpf(String cpf){
        return cpf.replaceFirst("^[0-9]{3}.[0-9]{3}.[0-9]{3}-", "***.***.***-");
    }

    public static String maskCnpj(String cnpj){
        return cnpj.replaceFirst("^[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}", "**-***-***/****");
    }

    public static String clearCpf(String cpf){
        return cpf.replaceAll("[^0-9]+", "");
    }

    public static String clearCnpj(String cnpj){
        return cnpj.replaceAll("[^0-9]+", "");
    }

    public static String clearTel(String telefone){
        return telefone.replaceAll("[^0-9]+", "");
    }

    public static String formatCpf(String cpf){
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static String formatCnpj(String cnpj){
        return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }

    public static String formatTel(String telefone){
        return telefone.replaceAll("(\\d{2})(\\d{4,5})(\\d{4})", "($1)$2-$3").trim();
    }

    public static String formatCep(String cep){
        return cep.replace("-", "");
    }
}
