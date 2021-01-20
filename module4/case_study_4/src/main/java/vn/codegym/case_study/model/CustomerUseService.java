package vn.codegym.case_study.model;

public class CustomerUseService {
    private String customerName;
    private String customerAddress;
    private Contract contract;
    private Service service;
    private ContractDetail contractDetail;
    private AttachService attachService;

    public CustomerUseService() {
    }

    public CustomerUseService(String customerName, String customerAddress, Contract contract, Service service,
                              ContractDetail contractDetail, AttachService attachService) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contract = contract;
        this.service = service;
        this.contractDetail = contractDetail;
        this.attachService = attachService;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
