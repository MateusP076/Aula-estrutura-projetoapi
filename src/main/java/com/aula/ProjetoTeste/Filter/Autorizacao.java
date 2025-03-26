package com.aula.ProjetoTeste.Filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.aula.ProjetoTeste.User.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
@Component
public class Autorizacao extends OncePerRequestFilter {
    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            var autorizacao= request.getHeader("Authorization");
            filterChain.doFilter(request,response);
            System.out.println("autorizacao: ");
            System.out.println(autorizacao);

            var Autoencode=autorizacao.substring("Basic".length()).trim();
            System.out.println("autorizacao: ");
            System.out.println(Autoencode);

            byte[]Autoencoder= Base64.getDecoder().decode(Autoencode);
            System.out.println("Autorização");
            System.out.println(Autoencoder);

            var autorizacaoinit= new String(Autoencoder);
        System.out.println(autorizacaoinit);
        String[]credenciais=autorizacaoinit.split(":");
        String usuario=credenciais[0];
        String senha=credenciais[1];
        System.out.println(usuario);
        System.out.println(senha);

        var user=this.userRepository.findByUsername(usuario);
        if(user==null){
            response.sendError(401,"Nao funciona, Usuario inexistente");
        }else {
            var senhaverifica= BCrypt.verifyer().verify(senha.toCharArray(),user.getSenha());
                if (senhaverifica.verified){
                    filterChain.doFilter(request,response);
                }else {
                        response.sendError(401,"Senha Incorreta");
                }
        }
    }
}
