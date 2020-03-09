package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.print.MultiDocPrintService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Oversigt extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        List<User> users = UserMapper.getAllUsers();

        session.setAttribute("users", users);

        return "oversigt";
    }
}
