//
//  CreditCardViewController.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class CreditViewController: UIViewController {
    @IBOutlet weak var firstLayerContainerView: UIView!
    @IBOutlet weak var spedingLimitTextField: UITextField!
    @IBOutlet weak var buttonLeft: UIButton!
    @IBOutlet weak var eventImageView: UIImageView!
    
    @IBOutlet weak var submitButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        spedingLimitTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        submitButton.roundedButton(arrow: .arrowRight)
        buttonLeft.roundedButton(arrow: .arrowLeft)
        eventImageView.layer.cornerRadius = 10
        firstLayerContainerView.layer.cornerRadius = 10
    }
}
