//
//  CreditCardViewController.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

protocol AddLimiteDelegate: class {
    func addLimite(_ amount: String?)
}

class CreditViewController: UIViewController {
    @IBOutlet weak var containerView: UIView!
    @IBOutlet weak var firstLayerContainerView: UIView!
    @IBOutlet weak var spedingLimitTextField: UITextField!
    @IBOutlet weak var buttonLeft: UIButton!
    @IBOutlet weak var eventImageView: UIImageView!
    @IBOutlet weak var submitButton: UIButton!
    weak var addLimitDelegate: AddLimiteDelegate?
    
    static func instance()-> CreditViewController {
        return UIStoryboard.storyboard(.creditLimit).instantiateViewController() as CreditViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
    }
    
    @IBAction func addLimit(_ sender: Any) {
        if let limit = spedingLimitTextField.text, !limit.isEmpty {
            addLimitDelegate?.addLimite(limit)
        self.navigationController?.popViewController(animated: true)
        }else{
            Alert.defaultAlert(for: self, title: "Campo Vazio", message: "Você precisa definir seu limite de gastos.")
        }
    }
}

extension CreditViewController {
    private func setupView() {
        DispatchQueue.main.async {
            self.containerView.addCornerRadius(10)
            self.spedingLimitTextField.addBottomBorderWithColor(color: UIColor.black, height: 1)
            self.submitButton.roundedButton(icon: .arrowRight)
            self.buttonLeft.roundedButton(icon: .arrowLeft)
            self.eventImageView.layer.cornerRadius = 10
            self.firstLayerContainerView.layer.cornerRadius = 10
        }
    }
}


extension CreditViewController: Identifiable {}
