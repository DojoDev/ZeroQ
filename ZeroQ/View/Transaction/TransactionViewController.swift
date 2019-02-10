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
    
    @IBOutlet weak var createGroupButton: UIButton!
    @IBOutlet weak var buyContainer: UIView!
    @IBOutlet weak var payContainer: UIView!
    @IBOutlet weak var buttonLeft: UIButton!
    @IBOutlet weak var buttonRight: UIButton!
    @IBOutlet weak var buyImageView: UIImageView!
    @IBOutlet weak var payImageView: UIImageView!
   
    static func instance()-> TransactionViewController {
        return UIStoryboard.storyboard(.transaction).instantiateViewController() as TransactionViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        createGroupButton.layer.cornerRadius = 25
        buyImageView.image = UIImage(named: "soda")
        payImageView.image = UIImage(named: "pay")
        eventImageView.layer.cornerRadius = 10
        buyContainer.layer.cornerRadius = 10
        payContainer.layer.cornerRadius = 10
        buttonLeft.rounded()
        buttonRight.rounded()
        
        buttonLeft.titleLabel?.font = UIFont.fontAwesome(ofSize: 30, style: .solid)
        buttonLeft.setTitle(String.fontAwesomeIcon(name: .arrowLeft), for: .normal)
        
        buttonRight.titleLabel?.font = UIFont.fontAwesome(ofSize: 30, style: .solid)
        buttonRight.setTitle(String.fontAwesomeIcon(name: .arrowRight), for: .normal)

    }
    
    @IBAction func createGroupe(_ sender: Any) {
    }
}

extension TransactionViewController: Identifiable {}
