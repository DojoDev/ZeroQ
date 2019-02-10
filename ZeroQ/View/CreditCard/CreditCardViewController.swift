//
//  CreditCardViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit
import PayCardsRecognizer
import FontAwesome_swift

class CreditCardViewController: UIViewController, PayCardsRecognizerPlatformDelegate {

    @IBOutlet weak var readCardButton: UIButton!
    @IBOutlet weak var cvvTextField: UITextField!
    @IBOutlet weak var expirationTextField: UITextField!
    @IBOutlet weak var cardNumberTextField: UITextField!
    @IBOutlet weak var nameTextField: UITextField!
    var recognizer: PayCardsRecognizer!
    override func viewDidLoad() {
        super.viewDidLoad()
        cvvTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        expirationTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        cardNumberTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        nameTextField.addBottomBorderWithColor(color: UIColor.black, height: 2)
        recognizer = PayCardsRecognizer(delegate: self, resultMode: .async, container: self.view, frameColor: .green)
        
        readCardButton.addCornerRadius(25)
        readCardButton.titleLabel?.font = UIFont.fontAwesome(ofSize: 30, style: .solid)
        readCardButton.setTitle(String.fontAwesomeIcon(name: .camera), for: .normal)
        readCardButton.setTitleColor(UIColor.white, for: .normal)
    }
    
    @IBAction func readCard(_ sender: Any) {
        recognizer.startCamera()
    }
    func payCardsRecognizer(_ payCardsRecognizer: PayCardsRecognizer, didRecognize result: PayCardsRecognizerResult) {
       
        cardNumberTextField.text = result.recognizedNumber
        nameTextField.text = result.recognizedHolderName
        if let month = result.recognizedExpireDateMonth, let year = result.recognizedExpireDateYear {
               expirationTextField.text = "\(month)/\(year)"
        }
     
         recognizer.stopCamera()
    }
}
