public class BankAccount {
    private String type;
    //แบบ Inheritance
    public void transferMoney(BankAccount target, double amount){
        //Logic
        // 1. Local
        if("Local".equals(target.type)){
            //TODO
        }

        // 2. Inter
        else if("INTER".equals(target.type)){ // แบบนี้มันผิดกฏ SRP Single Responsibility
            //TODO
        }

        // 3. Others

    }
    //สร้าง class ใหม่ มันจะเป็น OCP คนเรียกใช้จะใช้ Local หรือ Inter ก็ New เอา
    class InterBankAccount extends  BankAccount{
        @Override // override
        public void transferMoney(BankAccount target, double amount) {
            super.transferMoney(target, amount);
        }
    }
    class Client{
        void process(){
            new BankAccount().transferMoney(null,1000); //แบบนี้ถ้าแก้จะพัง transferMoney ใน BankAccount จะพัง
            new InterBankAccount().transferMoney(null,1000);
        }
    }
}
