//
//  TransactionViewController.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit



class TransactionViewController: UIViewController {
    @IBOutlet weak var eventImageView: UIImageView!
    
    @IBOutlet weak var spendLimitButton: UILabel!
    @IBOutlet weak var createGroupButton: UIButton!
    @IBOutlet weak var buyContainer: UIView!
    @IBOutlet weak var payContainer: UIView!
    @IBOutlet weak var buttonLeft: UIButton!
    @IBOutlet weak var buttonRight: UIButton!
    @IBOutlet weak var buyImageView: UIImageView!
    @IBOutlet weak var payImageView: UIImageView!
    var lastButtonState: UIControl.State?
    static func instance()-> TransactionViewController {
        return UIStoryboard.storyboard(.transaction).instantiateViewController() as TransactionViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
        configGesture()
    }
  
    @objc func openPurchase() {
        let instance = PurchaseViewController.instance()
       self.navigationController?.pushViewController(instance, animated: true)
    }
    
    @objc func openPay() {
        let instance = PaymentViewController.instance()
        self.navigationController?.pushViewController(instance, animated: true)
    }
    
    @objc func defineASpendingLimit(sender:UITapGestureRecognizer) {
        let instance = CreditViewController.instance()
        instance.addLimitDelegate = self
        self.navigationController?.pushViewController(instance, animated: true)
    }
    
    @IBAction func createGroupe(_ sender: Any) {
        let instance = GroupViewController.instance()
        self.navigationController?.pushViewController(instance, animated: true)
    }
}

extension TransactionViewController {
    private func setupView() {
        spendLimitButton.underline()
        payContainer.isUserInteractionEnabled = false
        buyContainer.isUserInteractionEnabled = false
        createGroupButton.layer.cornerRadius = 20
        buyImageView.image = UIImage(named: "soda")
        payImageView.image = UIImage(named: "pay")
        eventImageView.layer.cornerRadius = 10
        buyContainer.layer.cornerRadius = 10
        payContainer.layer.cornerRadius = 10
    }
    
    private func configGesture() {
        let tap = UITapGestureRecognizer(target: self, action: #selector(TransactionViewController.defineASpendingLimit))
        spendLimitButton.addGestureRecognizer(tap)
        
        let tapBuy = UITapGestureRecognizer(target: self, action: #selector(TransactionViewController.openPurchase))
        buyContainer.addGestureRecognizer(tapBuy)
        
        let tapPay = UITapGestureRecognizer(target: self, action: #selector(TransactionViewController.openPay))
        payContainer.addGestureRecognizer(tapPay)
    }
}

extension TransactionViewController: Identifiable {}

extension TransactionViewController: AddLimiteDelegate {
    func addLimite(_ amount: String?) {
        DispatchQueue.main.async {
            self.spendLimitButton.text = "Total Gasto: R$ 0"
            self.spendLimitButton.isUserInteractionEnabled = false
            self.createGroupButton.isHidden = false
            let backColor = UIColor.init(displayP3Red: 1, green: 1, blue: 1, alpha: 0.8)
            self.payContainer.isUserInteractionEnabled = true
            self.buyContainer.isUserInteractionEnabled = true
            self.buyContainer.backgroundColor = backColor
            self.payContainer.backgroundColor = backColor
            self.buyImageView.backgroundColor = backColor
            self.payImageView.backgroundColor = backColor
        }
    }
}
