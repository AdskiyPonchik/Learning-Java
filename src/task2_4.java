public class task2_4 {
    public static String test() {
        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        StringBuilder[] result = new StringBuilder[roles.length];
        for (int i = 0; i < roles.length; i++) {
            result[i] = new StringBuilder();
            result[i].append(roles[i] + ":\n");
        }
        for(int i = 0; i < textLines.length; i++) {
            String rolename = textLines[i].substring(0, textLines[i].indexOf(":"));
            String text = textLines[i].substring(textLines[i].indexOf(':') + 1);
            for (int j = 0; j < roles.length; j++) {
                if (roles[j].equals(rolename)) {
                    result[j].append(i + 1).append(") ").append(text).append('\n');
                    break;
                }
            }
        }
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i <result.length;i++){
                builder.append(result[i]);
                if(i < result.length-1){
                    builder.append('\n');
                }
            }
        return builder.toString();
    }
}
