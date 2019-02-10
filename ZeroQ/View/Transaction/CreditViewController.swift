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
        addLimitDelegate?.addLimite(spedingLimitTextField.text)
        self.navigationController?.popViewController(animated: true)
    }
}

extension CreditViewController {
    private func setupView() {
        containerView.addCornerRadius(10)
        spedingLimitTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        submitButton.roundedButton(icon: .arrowRight)
        buttonLeft.roundedButton(icon: .arrowLeft)
        eventImageView.layer.cornerRadius = 10
        firstLayerContainerView.layer.cornerRadius = 10
    }
}

extension CreditViewController: Identifiable {}
