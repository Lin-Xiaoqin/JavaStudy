import io.javalin.Javalin;

import java.util.ArrayList;

public class App {

    public static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void initContacts(){
        contacts.add(new Contact("石原さとみ","666"));
        contacts.add(new Contact("新垣　結衣","888"));
    }

    public static void main(String[] args) {
        initContacts();
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));

        app.get("/contacts", ctx -> {
            //ctx.result(contacts.toString());
            ctx.json(contacts);
        });

        app.get("/contacts/:id", ctx -> {
            int idx = -1;
            try{
                idx = Integer.parseInt(ctx.pathParam("id"));
                if (idx >-1&& idx < contacts.size()){
                    ctx.json(contacts.get(idx));
                }else {
                    ctx.result("index is out of boundaries").status(404);
                } }
            catch(Exception ex){
                    ctx.status(404);
                }
        });
    }
}

