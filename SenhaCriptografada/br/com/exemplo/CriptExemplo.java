package br.com.exemplo;

import java.security.MessageDigest;
import java.util.Scanner;

public class CriptExemplo {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Digite uma senha para ser criptografada: ");
		String senha = scanner.next();
		System.out.println("Senha digitada, sem criptografia: " +senha);
		String novaSenha = criptografar(senha);
		System.out.println("Senha criptografada: " +novaSenha);

	}
	
	public static String criptografar(String senha){
		try{
			MessageDigest digs = MessageDigest.getInstance("SHA-256");
			digs.update((new String(senha)).getBytes("UTF8"));
			String senhaCript  = new String(digs.digest());
			return senhaCript;
		}catch (Exception e){
			System.out.println("Erro ao criptografar" + e);
			return "";
		}
	}

}
