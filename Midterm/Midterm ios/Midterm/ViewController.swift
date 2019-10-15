//
//  ViewController.swift
//  Midterm
//
//  Created by Jennifer Mah on 10/15/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
//outlets
    
    @IBOutlet weak var communteMiles: UITextField!
    @IBOutlet weak var commuteButton: UIButton!
    @IBOutlet weak var mins: UILabel!
    @IBOutlet weak var GAS: UILabel!
    @IBOutlet weak var month: UISwitch!
    @IBOutlet weak var gasGallons: UILabel!
    @IBOutlet weak var imageControl: UISegmentedControl!
    
    @IBOutlet weak var iconImage: UIImageView!
    
    
    //actions
    
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0{
            iconImage.image=UIImage(named: "car_icon")
            calculateMonthly("car")
            CalcCommute(20.0)
            CalcGas(24)
            
        }
        
        
        else if imageControl.selectedSegmentIndex == 1{
            calculateMonthly("bus")
            iconImage.image=UIImage(named: "bus_icon")
           CalcCommute(12)
            CalcGas(0)

            
        }else if imageControl.selectedSegmentIndex == 2{
            calculateMonthly("bike")
            iconImage.image=UIImage(named: "bike_icon")
           CalcCommute(10)
            CalcGas(0)

        }
    }
    
    @IBAction func changeInfo(_ sender: Any) {
        updateImage()
    }
    
    
    
    @IBAction func GasSlider(_ sender: UISlider) {
        let gallonsOfGas = sender.value
        gasGallons.text=String(format: "%.0f", gallonsOfGas) + " gallons"
    }
    
    func calculateMonthly(_ test: String){
        if month.isOn {
            if test == "car" {
                let totalCommute = CalcCommute(20)*20
                mins.text=String(format: "%.0f", totalCommute)
                let totalmiles = CalcGas(24.0)*20
                GAS.text=String(format: "%.0f", totalmiles)
            }else if test == "bus" {
                let totalCommute = CalcCommute(12)*20
                mins.text=String(format: "%.0f", totalCommute)
                let totalmiles = CalcGas(0)*20
                GAS.text=String(format: "%.0f", totalmiles)
            }else if test == "bike"{
                let totalCommute = CalcCommute(10)*20
                print("totalCommute")
                mins.text=String(format: "%.0f", totalCommute)
                let totalmiles = CalcGas(0)*20
                GAS.text=String(format: "%.0f", totalmiles)
            }

            
        }else{
            if test == "car" {
                CalcCommute(20)
                CalcGas(24.0)
            }
            else if test == "bus" {
                CalcCommute(12)
                CalcGas(0)
            }else if test == "bike"{
                CalcCommute(10)
                CalcGas(0)
        }
            
        }
    }

    @IBAction func changeMonth(_ sender: Any) {
        if imageControl.selectedSegmentIndex == 0{
            calculateMonthly("car")}

        else if imageControl.selectedSegmentIndex == 1{
            calculateMonthly("bus")}
        else if imageControl.selectedSegmentIndex == 2{
            calculateMonthly("bike")}
        
//        let time = CalcCommute(20)
//        let gas = CalcGas(24.0)
//        if month.isOn {
//            let totalCommute = time*20
//            mins.text=String(format: "%.0f", totalCommute)
//            let totalmiles = gas*20
//            GAS.text=String(format: "%.0f", totalmiles)
//        }
    }
    
    
    @IBAction func pressCommuteButton(_ sender: Any) {
        let commute = CalcCommute(20)
        print(commute)
        let gas = CalcGas(24.0)
        print(gas)
    }
    //logic to calculate commute time
    //logic to calculate fat to pirchase
    func CalcCommute(_ milage: Float) ->Float {
        
        var amount:Float
        var hours:Float
        var minutes:Float
        if Float(communteMiles.text!)! > 50.0{
            let alertConroller = UIAlertController(title: "WARNING", message: "commute is over 50 miles", preferredStyle: .alert)
            let alertAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
            alertConroller.addAction(alertAction)
            present(alertConroller,animated:true, completion: nil)
        }
        if communteMiles.text!.isEmpty {
            amount = 0.0
            mins.text=String(format: "%.0f", amount)
            return amount
        } else {
            
            amount = Float(communteMiles.text!)!
            print(amount)
            hours=amount/milage
            print(hours)
            minutes=hours*60
            print("BEFORE")
            print(minutes)
            if milage == 12{
              minutes=minutes+5 //im assuming the commute is one way.
            }
            mins.text=String(format: "%.0f", minutes)
            return minutes
        }
    }
    
    //calc cas
    func CalcGas(_ gal: Float)->Float {
        var amount:Float
        var gallons:Float
        if communteMiles.text!.isEmpty || gal == 0.0 {
            amount = 0.0
            GAS.text=String(format: "%.0f", amount)
            GAS.text=String(format: "%.2f", amount)
            return amount
            
        } else {
            amount = Float(communteMiles.text!)!
            print(amount)
            gallons=amount/gal
            GAS.text=String(format: "%.2f", gallons)
            return gallons
        }

    }
    
//functions

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        if Float(communteMiles.text!)! > 50.0{
            let alertConroller = UIAlertController(title: "Warning", message: "commute is over 50 miles", preferredStyle: .alert)
            let alertAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
            alertConroller.addAction(alertAction)
            present(alertConroller,animated:true, completion: nil)
            
        }
        return true
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        communteMiles.delegate = self
        
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard)); view.addGestureRecognizer(tap)
    }
    
    @objc func dismissKeyboard() { view.endEditing(true)
    }
    

}

