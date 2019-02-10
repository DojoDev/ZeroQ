//
//  GroupViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class GroupViewController: UIViewController {

    @IBOutlet weak var buttonAdd: UIButton!
    @IBOutlet weak var marcosImageView: UIImageView!
    @IBOutlet weak var lauraImageView: UIImageView!
    @IBOutlet weak var createGroupButton: UIButton!
    @IBOutlet weak var leftButton: UIButton!
    @IBOutlet weak var groupNameTextField: UITextField!
    
    static func instance()-> GroupViewController {
        return UIStoryboard.storyboard(.group).instantiateViewController() as GroupViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
    }

    @IBAction func createGroup(_ sender: Any) {
        let instance = PurchaseViewController.instance()
        self.navigationController?.pushViewController(instance, animated: true)
    }
}

extension GroupViewController {
    private func setupView() {
        createGroupButton.addCornerRadius(25)
        leftButton.roundedButton(icon: .arrowLeft)
        groupNameTextField.layer.cornerRadius = 10
        marcosImageView.rounded()
        lauraImageView.rounded()
        buttonAdd.rounded()
    }
}

extension GroupViewController: Identifiable {}
