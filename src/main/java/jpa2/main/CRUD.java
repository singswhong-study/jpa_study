package jpa2.main;

import jpa2.Emf.EMF;
import jpa2.entity.Member;
import jpa2.service.UserService;

public class CRUD {

    private static UserService userService = new UserService();

    public static void main(String[] args) {

        EMF.init();

        String type = "D";

        try {
            if("C".equals(type)){
                Member u = new Member("HONG", "F");
                userService.saveUser(u);
            } else if("R".equals(type)){
                Member u = userService.getUser(1L);
                System.out.println(u.toString());
            } else if("U".equals(type)){
                userService.updateUser(1L, "PPP");
            } else {
                userService.removeUser(2L);
            }
        } catch (Exception e){

        } finally {
            EMF.close();
        }

    }

}
