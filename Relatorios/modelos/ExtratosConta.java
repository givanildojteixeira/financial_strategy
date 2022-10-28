package Relatorios.modelos;

import console.Ferramentas;
import dominio.ContaProduct;

public class ExtratosConta {
	Ferramentas f = new Ferramentas();

	public String getExtrato(ContaProduct contaProduct) {

		String extrato = "";
		extrato += "-------------------------------\n";
		extrato += "-    EXTRATO CONTA CORRENTE   -\n";
		extrato += "-------------------------------\n";
		extrato += "Conta Nro: " + contaProduct.getNumero() + "\n";
		extrato += "Cliente  : " + contaProduct.getNome() + "\n";
		extrato += "Tipo Cta : " + contaProduct.getTipo() + "\n";
		extrato += "Especial : " + contaProduct.getEspecial() + "\n";
		// extrato += "-------------------------------\n";
		// extrato += " MOVIMENTAÇÃO \n";
		// extrato += "-------------------------------\n";
		// extrato += "IdOp T VALOR DESCRICAO \n";
		// extrato += getMovimento();
		extrato += "-------------------------------\n";
		extrato += "Descrição        | Valor (R$)\n";
		// extrato += "-------------------------------\n";
		extrato += "Saldo            | R$" + f.cMB(contaProduct.getSaldo()) + "\n";
		extrato += "Limite           | R$" + f.cMB(contaProduct.getLimite()) + "\n";
		// extrato += "Limite | R$" + converteMoedaBrasil(getSaldoComLimite() -
		// getSaldo()) + "\n";
		// extrato += "Saldo com Limite | R$" + converteMoedaBrasil(getSaldoComLimite())
		// + "\n";
		extrato += "-------------------------------\n";
		return extrato;
	}


}
