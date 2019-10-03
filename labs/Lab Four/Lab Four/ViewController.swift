//
//  ViewController.swift
//  Lab Four
//
//  Created by Jennifer Mah on 10/2/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    //outlets
    @IBOutlet weak var favCookie: UITextField!
    @IBOutlet weak var peopleNumberLabel: UILabel!
    @IBOutlet weak var peopleStepper: UIStepper!
    @IBOutlet weak var FinalText: UILabel!
    
    //actions
    //updates people label
    @IBAction func peopleUpdate(_ sender: UIStepper) {
        if peopleStepper.value == 1{
            peopleNumberLabel.text = " 1 person"
        } else{
            peopleNumberLabel.text = String(format: "%.0f", peopleStepper.value) + " people"
        }
        checkTextFilled()
        updateCookieAmmount()
    }
    
    //functions
    
    //dimiss key board make sure to add the deligate to view did load function
    func checkTextFilled(){
        if favCookie.text!.isEmpty{
            let alert=UIAlertController(title: "Warning", message: "You must enter a favorite cookie", preferredStyle: UIAlertController.Style.alert)
            let cancel=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancel)
            let okay=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: nil)
            alert.addAction(okay)
            present(alert, animated: true, completion: nil)
        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        checkTextFilled()
        updateCookieAmmount()
        return true
    }
    
    
    //function to calculate the number of cookies needed
    func updateCookieAmmount(){
        let numberOfPeeps = peopleStepper.value
        var cookieType:String
        cookieType = favCookie.text!
        
        if peopleStepper.value < 1 {
            //alert to tell the user you can't have 0 people
            let alert=UIAlertController(title: "Warning", message: "The number of people must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.peopleStepper.value = 1
                self.peopleNumberLabel.text? = "1 person"
                self.updateCookieAmmount()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        
        
        //math to calculate how many cookies needed to bake
        let numberOfCookies = numberOfPeeps*2
        FinalText.text = "You need to bake " + String(format: "%.0f" ,numberOfCookies) + " " + cookieType + " cookies."
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        favCookie.delegate=self
        // Do any additional setup after loading the view.
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard)); view.addGestureRecognizer(tap)
        
    }
    @objc func dismissKeyboard() { view.endEditing(true)
        checkTextFilled()
        updateCookieAmmount()
    }



}

