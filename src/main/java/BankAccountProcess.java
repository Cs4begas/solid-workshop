interface BankAccountProcess //แยกหน้าที่รับผิดชอบ
{
        public void transferMoney(BankAccount target,double amount);
}
class LocalBankAccount implements  BankAccountProcess{

    @Override
    public void transferMoney(BankAccount target, double amount) {
        // Local
    }
}
class InterBankAccount implements BankAccountProcess {
    @Override
    public void transferMoney(BankAccount target, double amount) {
        //Inter
    }
}

class TransferProcess { //เหมือนโรงงาน
    BankAccountProcess process(String type){
        if("Local".equals(type)){
            return new LocalBankAccount();
        } // แค่แยก
        if("INTER".equals(type)){
            return new InterBankAccount();
        }
        throw new RuntimeException("NO");
    }
}

class Client{
    void start(String type, BankAccount target, int opts) {
        TransferProcess transferProcess = new TransferProcess(); // new ตรงนี้เอา
        transferProcess.process("Local").transferMoney(target,1000);
        transferProcess.process("INTER").transferMoney(target,1000);
    }
    //API1 ไป Inject เอา
    void startForLocal(BankAccount target, double amount){
        new LocalBankAccount().transferMoney(target, amount);
    }
    //API2
    void startForInter(BankAccount target, double amount){
        new InterBankAccount().transferMoney(target, amount);
    }
}

