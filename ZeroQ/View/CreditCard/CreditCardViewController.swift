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

class CreditCardViewController: UIViewController {

    @IBOutlet weak var readCardButton: UIButton!
    @IBOutlet weak var cvvTextField: UITextField!
    @IBOutlet weak var expirationTextField: UITextField!
    @IBOutlet weak var cardNumberTextField: UITextField!
    @IBOutlet weak var nameTextField: UITextField!
    var recognizer: PayCardsRecognizer!
    static func instance()-> CreditCardViewController {
        return UIStoryboard.storyboard(.creditCard).instantiateViewController() as CreditCardViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
    }
    
    @objc func readCard() {
        recognizer.startCamera()
    }
}

extension CreditCardViewController: PayCardsRecognizerPlatformDelegate {
    private func setupView() {
        self.title = "CARTÃO DE CRÉDITO"
        cvvTextField.delegate = self
        nameTextField.delegate = self
        readCardButton.titleLabel?.font = UIFont.fontAwesome(ofSize: 30, style: .solid)
        readCardButton.setTitle(String.fontAwesomeIcon(name: .camera), for: .normal)
        readCardButton.setTitleColor(UIColor.white, for: .normal)
        readCardButton.addTarget(self, action: #selector(readCard), for: .touchUpInside)
        DispatchQueue.main.async {
            self.cvvTextField.addBottomBorderWithColor(color: UIColor.black, height: 1)
            self.expirationTextField.addBottomBorderWithColor(color: UIColor.black, height: 1)
            self.cardNumberTextField.addBottomBorderWithColor(color: UIColor.black, height: 1)
            self.nameTextField.addBottomBorderWithColor(color: UIColor.black, height: 1)
            self.recognizer = PayCardsRecognizer(delegate: self, resultMode: .async, container: self.view, frameColor: .green)
            self.readCardButton.addCornerRadius(25)
        }
    }
    
    func payCardsRecognizer(_ payCardsRecognizer: PayCardsRecognizer, didRecognize result: PayCardsRecognizerResult) {
        
        cardNumberTextField.text = result.recognizedNumber
        nameTextField.text = result.recognizedHolderName
        if let month = result.recognizedExpireDateMonth, let year = result.recognizedExpireDateYear {
            expirationTextField.text = "\(month)/\(year)"
        }
        
        recognizer.stopCamera()
    }
    
    @objc private func popViewController(){
        self.navigationController?.popViewController(animated: true)
    }
}

extension CreditCardViewController: UITextFieldDelegate {
    func textFieldDidEndEditing(_ textField: UITextField) {
        if let name = nameTextField.text, !name.isEmpty, let cvv = cvvTextField.text, !cvv.isEmpty {
            readCardButton.setTitle("OK", for: .normal)
            readCardButton.removeTarget(self, action: nil, for: .touchUpInside)
            readCardButton.addTarget(self, action: #selector(popViewController), for: .touchUpInside)
            
        }else {
            readCardButton.addTarget(self, action: #selector(readCard), for: .touchUpInside)
            readCardButton.setTitle(String.fontAwesomeIcon(name: .camera), for: .normal)
        }
    }
}

extension CreditCardViewController: Identifiable {}
