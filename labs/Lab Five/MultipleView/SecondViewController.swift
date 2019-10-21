//
//  SecondViewController.swift
//  MultipleView
//
//  Created by Jennifer Mah on 10/3/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController,UITextFieldDelegate {
    @IBOutlet weak var foodText: UITextField!
    @IBOutlet weak var chefText: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "done"{
            let scene1ViewController = segue.destination as! ViewController
            //check to see that text was entered in the textfields
            if foodText.text!.isEmpty == false{
                scene1ViewController.user.favDish=foodText.text
            }
            if chefText.text!.isEmpty == false{
                scene1ViewController.user.favChef=chefText.text
            }
        }
    }
    
    
    override func viewDidLoad() {
        foodText.delegate = self
        chefText.delegate = self
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
   
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    
}
